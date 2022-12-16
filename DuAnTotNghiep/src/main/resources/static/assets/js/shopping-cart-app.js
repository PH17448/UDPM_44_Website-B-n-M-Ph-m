const app = angular.module("shopping-cart-app",[]);
app.controller("shopping-cart-ctrl",function ($scope,$http) {
   $scope.payment = [] ;

   $scope.getPayment = function () {
        $http.get("/rest/payments").then(resp => {
            $scope.payments = resp.data ; 
        })
   }
   
   $scope.getPayment();
   
    $scope.cart = {
        items:[] ,
        
        //Thêm vào giỏ hàng
        add(id){
            var item = this.items.find(item => item.id == id);
            if(item){
                item.qty++;
                this.saveToLocalStorage();
            }
            else{
                $http.get(`/rest/products/${id}`).then(resp => {
                    resp.data.qty = 1;
                    this.items.push(resp.data);
                    this.saveToLocalStorage();
                })
            }
        } ,

        //Xóa sản phẩm khỏi giỏ hàng
        remove(id){
            var index = this.items.findIndex(item => item.id == id);
            this.items.splice(index,1);
            this.saveToLocalStorage();
        },

        //Xóa sạch mặt hàng khỏi giỏ
        clear(){
            this.items=[]
            this.saveToLocalStorage();
        },

        //Tính tiền 1 sản phẩm
        amt_of(){},

        //Tính tổng số lượng mặt hàng trong giỏ
        get count(){
            return this.items
                .map(item => item.qty)
                .reduce((total,qty) => total += qty,0);
        },

        //Tính tổng tiền tất cả các mặt hàng trong giỏ
        get amount(){
            return this.items
                .map(item => item.qty * item.price)
                .reduce((total,qty) => total += qty,0);
        },

        //Lưu giỏ hàng vào local storage
        saveToLocalStorage(){
            var json = JSON.stringify(angular.copy(this.items));
            localStorage.setItem("cart",json);
        },

        //Đọc giỏ hàng từ localStorage
        loadFromLocalStorage(){
            var json =  localStorage.getItem("cart");
            this.items = json ? JSON.parse(json) : [] ;
        }
    }
    $scope.cart.loadFromLocalStorage();

    $scope.order = {

        createDate : new Date() ,
        address : "" ,
        phone : "",
        accountOrder : {email: $("#username").text()},
        payment : {id: 0} ,
        voucher :{code:$("#code").text()},
        status : 0 ,
        get orderDetails(){
            return $scope.cart.items.map(item => {
                return {
                    product : {id:item.id},
                    price : item.price ,
                    quantity :item.qty 
                }
            })
        }  , 
  
        purchase(){
            var order = angular.copy(this) ;
            //Thực hiện đặt hàng 
            $http.post("/rest/orders",order).then(resp => {
                alert("Đặt hàng thành công !");
                $scope.cart.clear();
                location.href = "/order/detail/"+resp.data.id ;
            }).catch(error => {
                alert("Đặt hàng lỗi !")
                console.log(error);
            })
        }
    }
})