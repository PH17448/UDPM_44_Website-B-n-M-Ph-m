-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th10 28, 2022 lúc 03:59 PM
-- Phiên bản máy phục vụ: 10.4.22-MariaDB
-- Phiên bản PHP: 7.4.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `websitebanmypham`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `accounts`
--

CREATE TABLE `accounts` (
  `username` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `role_id` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `fullname` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `create_date` date NOT NULL,
  `phone` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `image` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `address` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `accounts`
--

INSERT INTO `accounts` (`username`, `role_id`, `password`, `fullname`, `email`, `create_date`, `phone`, `image`, `address`) VALUES
(NULL, NULL, NULL, NULL, '', '2022-11-25', '', 'user.jpg', ''),
(NULL, NULL, '123456', 'Nguyễn Văn Đương', 'cangohvt@gmail.com', '2022-11-23', '0965221785', NULL, 'Thôn Công An - xã Hoàng Văn Thụ - huyện Chương Mỹ-Hà Nội'),
(NULL, 'CUS', '123456', 'Nguyễn Văn Đương', 'cangohvt1@gmail.com', '2022-11-23', '0965221785', NULL, 'Thôn Công An - xã Hoàng Văn Thụ - huyện Chương Mỹ-Hà Nội'),
('duongnv', 'CUS', '123456', 'Nguyễn Văn Đương', 'duongnvph17448@fpt.edu.vn', '2022-11-02', '0965221785', 'em.jpg', 'Thôn Công An-Hoàng Văn Thụ-Chương Mỹ-Hà Nội'),
('minhbn', 'ADMIN', '123456', 'Bùi Ngọc Minh', 'minhbn@gmail.com', '2022-11-02', '0965221785', 'em.jpg', 'Thôn Công An-Xã Hoàng Văn Thụ - Chương Mỹ-Hà Nội');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `banner`
--

CREATE TABLE `banner` (
  `id` int(11) NOT NULL,
  `image` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `status` bit(11) NOT NULL DEFAULT b'1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `capacities`
--

CREATE TABLE `capacities` (
  `id` int(11) NOT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `product_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `capacities`
--

INSERT INTO `capacities` (`id`, `name`, `product_id`) VALUES
(1, '50ml', 1),
(2, '100ml', 1),
(3, '150ml', 1),
(4, '50ml', 2),
(5, '100ml', 2),
(6, '150ml', 2),
(7, '50ml', 3),
(8, '100ml', 3),
(9, '150ml', 3),
(10, '200ml', 3),
(11, '250ml', 3);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `categories`
--

CREATE TABLE `categories` (
  `id` int(11) NOT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `description` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `categories`
--

INSERT INTO `categories` (`id`, `name`, `description`) VALUES
(1, 'Chăm sóc tóc', 'Giúp phục hồi hư tổn các kiểu'),
(2, 'Chăm sóc mắt và môi', 'Chăm sóc mắt và môi các kiểu'),
(3, 'Chăm sóc da', 'Chăm sóc da các kiểu'),
(4, 'Serum, sản phẩm đặc trị', 'Serum sản phẩm đặc trị các kiểu'),
(5, 'Nước hoa', NULL),
(6, 'Chăm sóc cơ thể', NULL),
(7, 'Chăm sóc răng miệng', NULL),
(9, '', NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `contact`
--

CREATE TABLE `contact` (
  `id` int(11) NOT NULL,
  `content` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `status` bit(11) NOT NULL DEFAULT b'1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `discount_product`
--

CREATE TABLE `discount_product` (
  `id` int(11) NOT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `code` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `quantity` float NOT NULL,
  `apply_day` datetime(6) NOT NULL,
  `expiration` datetime(6) NOT NULL,
  `money_limit` decimal(11,0) NOT NULL,
  `create_day` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `discount_product`
--

INSERT INTO `discount_product` (`id`, `name`, `code`, `quantity`, `apply_day`, `expiration`, `money_limit`, `create_day`) VALUES
(1, 'Giảm 20%', 'vHUJ24HJt', 1, '2022-11-10 22:04:32.000000', '2022-11-18 22:04:32.000000', '20', '2022-11-02');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `favourite`
--

CREATE TABLE `favourite` (
  `id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `status` bit(11) NOT NULL DEFAULT b'0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `favourite`
--

INSERT INTO `favourite` (`id`, `product_id`, `status`) VALUES
(1, 1, b'00000000001');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `footer`
--

CREATE TABLE `footer` (
  `id` int(11) NOT NULL,
  `content` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `status` bit(11) DEFAULT b'1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `news`
--

CREATE TABLE `news` (
  `id` int(11) NOT NULL,
  `title` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `sumary` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `content` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `create_date` date NOT NULL DEFAULT current_timestamp(),
  `author` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `orders`
--

CREATE TABLE `orders` (
  `id` int(11) NOT NULL,
  `account_id` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `voucher_id` int(11) DEFAULT NULL,
  `payment_id` int(11) DEFAULT NULL,
  `address` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `create_date` datetime(6) NOT NULL,
  `phone` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `status` int(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `orders`
--

INSERT INTO `orders` (`id`, `account_id`, `voucher_id`, `payment_id`, `address`, `create_date`, `phone`, `status`) VALUES
(8, 'duongnvph17448@fpt.edu.vn', NULL, 1, 'Thôn Công An', '2022-11-21 00:00:00.000000', '0987654312', 4),
(14, 'duongnvph17448@fpt.edu.vn', NULL, 1, 'Thôn Công An', '2022-11-21 00:00:00.000000', '0987654321', 3),
(15, 'duongnvph17448@fpt.edu.vn', NULL, 2, 'abc', '2022-11-21 00:00:00.000000', '0987654322', 2),
(16, 'duongnvph17448@fpt.edu.vn', NULL, 1, 'Trần Văn Hiên', '2022-11-21 00:00:00.000000', '0965221785', 2),
(17, 'minhbn@gmail.com', NULL, 1, 'Tỉnh Hòa Bình', '2022-11-21 00:00:00.000000', '0987654321', 2),
(18, 'minhbn@gmail.com', NULL, 2, 'Thon Dai Linh', '2022-11-22 00:00:00.000000', '0987654321', 1),
(19, 'duongnvph17448@fpt.edu.vn', NULL, 1, 'Thôn Công An', '2022-11-23 00:00:00.000000', '0965221785', 3),
(20, 'duongnvph17448@fpt.edu.vn', NULL, 1, 'Ngõ 28', '2022-11-23 00:00:00.000000', '098765432', 2),
(21, 'duongnvph17448@fpt.edu.vn', NULL, 1, 'bcfgsdgsf', '2022-11-23 00:00:00.000000', '0987654', 1),
(22, 'duongnvph17448@fpt.edu.vn', NULL, 2, 'Ngõ 28 Đại Linh - Trung Văn', '2022-11-24 00:00:00.000000', '0987654321', 2),
(23, 'duongnvph17448@fpt.edu.vn', NULL, 1, 'aaaaaa-aaaaaaa', '2022-11-28 00:00:00.000000', '0987654321', 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `order_detail`
--

CREATE TABLE `order_detail` (
  `id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `order_id` int(11) NOT NULL,
  `price` float NOT NULL,
  `quantity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `order_detail`
--

INSERT INTO `order_detail` (`id`, `product_id`, `order_id`, `price`, `quantity`) VALUES
(1, 1, 1, 149000, 2),
(2, 2, 2, 150000, 5),
(3, 9, 2, 80000, 1),
(4, 8, 2, 110000, 1),
(5, 2, 3, 150000, 1),
(6, 9, 3, 80000, 1),
(7, 8, 3, 110000, 2),
(8, 3, 4, 72000, 1),
(9, 7, 4, 110000, 5),
(10, 5, 4, 60000, 1),
(11, 2, 5, 150000, 1),
(12, 4, 5, 45000, 2),
(13, 5, 5, 60000, 2),
(14, 2, 6, 150000, 2),
(15, 8, 6, 110000, 2),
(16, 9, 6, 80000, 1),
(17, 4, 6, 45000, 1),
(18, 6, 6, 70000, 5),
(19, 7, 6, 110000, 1),
(20, 2, 7, 150000, 5),
(21, 8, 8, 110000, 5),
(22, 2, 8, 150000, 1),
(23, 5, 8, 60000, 1),
(24, 6, 8, 70000, 1),
(25, 7, 8, 110000, 1),
(26, 3, 8, 72000, 3),
(27, 2, 12, 150000, 2),
(28, 2, 13, 150000, 1),
(29, 8, 14, 110000, 2),
(30, 2, 15, 150000, 1),
(31, 2, 16, 150000, 1),
(32, 8, 16, 110000, 1),
(33, 5, 16, 60000, 1),
(34, 4, 16, 45000, 1),
(35, 7, 16, 110000, 1),
(36, 2, 17, 150000, 5),
(37, 9, 17, 80000, 4),
(38, 8, 17, 110000, 3),
(39, 7, 17, 110000, 2),
(40, 6, 17, 70000, 3),
(41, 4, 17, 45000, 3),
(42, 5, 17, 60000, 3),
(43, 2, 18, 150000, 3),
(44, 2, 19, 150000, 2),
(45, 2, 20, 150000, 6),
(46, 9, 20, 80000, 1),
(47, 8, 20, 110000, 1),
(48, 2, 21, 150000, 3),
(49, 2, 22, 150000, 1),
(50, 9, 22, 80000, 3),
(51, 8, 22, 110000, 1),
(52, 2, 23, 150000, 4);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `payment`
--

CREATE TABLE `payment` (
  `id` int(11) NOT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `payment`
--

INSERT INTO `payment` (`id`, `name`) VALUES
(1, 'Thanh toán khi nhận hàng'),
(2, 'Trả qua thẻ');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `payment_history`
--

CREATE TABLE `payment_history` (
  `id` int(11) NOT NULL,
  `order_id` int(11) NOT NULL,
  `payment_id` int(11) NOT NULL,
  `total_money` float NOT NULL,
  `payment_date` date NOT NULL,
  `status` bit(11) NOT NULL DEFAULT b'1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `payment_history`
--

INSERT INTO `payment_history` (`id`, `order_id`, `payment_id`, `total_money`, `payment_date`, `status`) VALUES
(10, 8, 1, 216000, '2022-11-28', b'00000000001');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `products`
--

CREATE TABLE `products` (
  `id` int(11) NOT NULL,
  `sup_id` int(11) NOT NULL,
  `supcategory_id` int(11) NOT NULL,
  `discount_id` int(11) NOT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `price` float NOT NULL,
  `description` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `picture1` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `picture2` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `create_date` datetime(6) NOT NULL,
  `available` bit(11) NOT NULL DEFAULT b'1',
  `expire_date` datetime(6) NOT NULL,
  `quantity` int(11) NOT NULL,
  `quantity_sold` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `products`
--

INSERT INTO `products` (`id`, `sup_id`, `supcategory_id`, `discount_id`, `name`, `price`, `description`, `picture1`, `picture2`, `create_date`, `available`, `expire_date`, `quantity`, `quantity_sold`) VALUES
(1, 1, 2, 1, 'Dầu gội đầu khô batiste chính hãng nhập khẩu Anh Quốc', 149000, 'Với đặc thù là một loại son Lipstick, son OnColour Cream Lipstick của Oriflame được làm với thành phần chủ yếu là sáp và dầu khoáng. Giúp môi được dưỡng ẩm và không làm môi bị khô.\r\n\r\nBên cạnh đó với phức hợp Cream Comfort trong sản phẩm. Giúp cho bạn có ', 'daugoidau.jpg', 'daugoidau2.jpg', '2022-11-02 22:30:48.000000', b'00000000001', '2023-11-15 22:30:48.000000', 98, 2),
(2, 1, 2, 1, 'Dầu gôi ngăn dụng tóc Oriflame HairX Advanced Care', 150000, 'Gội phát khô đầu luôn', 'daugoidaunganrungtoc.jpg', 'daugoimilk.jpg', '2022-11-02 22:33:58.000000', b'00000000001', '2023-11-17 22:33:58.000000', 96, 4),
(3, 1, 5, 1, 'Sáp dưỡng ẩm Vaseline phục hồi da khô , nứt nẻ', 72000, 'Sáp dưỡng ẩm Vaseline là một sản phẩm quá đỗi quen thuộc trong các gia đình. Được xem là kem dưỡng ẩm số 1 tại Mỹ, với một lượng tiêu thụ lớn. Giúp làm mềm các vết sừng, chai sạn trên bề mặt da khắp các cơ thể như môi, tay, chân,… Chống việc bong tróc, nứ', 'sap-duong-moi-vasaline.jpg', '', '2022-11-09 09:58:38.000000', b'00000000001', '2023-11-25 09:58:38.000000', 47, 3),
(4, 1, 5, 1, 'Son dưỡng môi dạng thỏi Vaseline mềm mịn,giảm nứt nẻ, đa dạng mùi hương', 45000, 'Nếu môi bạn thường xuyên gặp tình trạng khô, nứt nẻ, thì son dưỡng môi Vaseline đích thị là một sản phẩm lý tưởng cho bạn đấy. Vừa có chức năng như son dưỡng vừa có thể sử dụng như một công cụ trang điểm. Giúp bảo vệ môi và giúp son lên màu chuẩn hơn.', 'son-duong-moi-vaseline.jpg', '', '2022-11-09 09:58:38.000000', b'00000000001', '2023-11-25 09:58:38.000000', 57, 3),
(5, 1, 5, 1, 'Sáp dưỡng môi Vasaline chống khô môi, nứt nẻ dạng hủ 7g', 60000, 'Sáp dưỡng môi Vaseline là một sản phẩm cứu tinh có cánh cho những bạn có đôi môi thường xuyên khô ráp, nứt nẻ. Cho bạn một đôi môi mềm mại và mượt mà. Hơn hết, bạn có thể dùng cho tất cả các vùng da trên cơ thể. Sản phẩm vô cùng tiện ích mà bất cứ cô gái ', 'sapduongamvaseline.jpg', '', '2022-11-09 09:58:38.000000', b'00000000001', '2023-11-25 09:58:38.000000', 57, 3),
(6, 1, 5, 1, 'Son dưỡng môi A-Z Lip Balm SPF 25 Oriflame', 70000, 'Nếu bạn đang tìm kiếm một loại son dưỡng làm mềm mịn môi thì son dưỡng môi A-Z Lip Balm SPF 25 Oriflame chính là sản phẩm bạn đang tìm đến. Thành phần từ nguồn thực vật sẽ liên tục nuôi dưỡng và làm dịu làn môi của bạn.', 'son-duong-moi-a-z-lip-balm-spf-25-oriflame.jpg', '', '2022-11-09 09:58:38.000000', b'00000000001', '2023-11-25 09:58:38.000000', 57, 3),
(7, 1, 5, 1, 'Son dưỡng Tender Care Protecting Balm Tinh dầu hạt quả lựu Oriflame 34042', 110000, 'Sản phẩm mới nhất từ son dưỡng Tender Care là Tender Care Protecting Balm Organic Pomegranate Seed Oil 34042 đang được rất nhiều chị em ưa chuộng', 'son-duong-tender.jpg', '', '2022-11-09 09:58:38.000000', b'00000000001', '2023-11-25 09:58:38.000000', 57, 3),
(8, 1, 5, 1, 'Son dưỡng OnColour Colour Boost Lip Balm 38764 Oriflame', 110000, 'Dạng son dưỡng có màu, giúp nuôi dưỡng làn môi của bạn trong tươi tắn, rạng rỡ với màu son vô cùng tự nhiên. \r\nCông thức son dưỡng môi Oncolour chứa thành phần tinh dầu mầm Lúa Mì và Vitamin E giúp nuôi dưỡng đôi môi căng mọng và đi kèm với hương thơm trá', 'son-duong-oncolour-colour-boost-lip-balm.jpg', '', '2022-11-09 09:58:38.000000', b'00000000001', '2023-11-25 09:58:38.000000', 57, 3),
(9, 1, 5, 1, 'Son OnColour Cream Lipstick Oriflame', 80000, 'Với đặc thù là một loại son Lipstick, son OnColour Cream Lipstick của Oriflame được làm với thành phần chủ yếu là sáp và dầu khoáng. Giúp môi được dưỡng ẩm và không làm môi bị khô.\r\n\r\nBên cạnh đó với phức hợp Cream Comfort trong sản phẩm. Giúp cho bạn có ', 'son-oncolour-cream-lipstick-oriflame.jpg', '', '2022-11-09 09:58:38.000000', b'00000000001', '2023-11-25 09:58:38.000000', 57, 3);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `roles`
--

CREATE TABLE `roles` (
  `id` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `roles`
--

INSERT INTO `roles` (`id`, `name`) VALUES
('ADMIN', 'Adminstrator'),
('CUS', 'CUSTOMER');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sub_categories`
--

CREATE TABLE `sub_categories` (
  `id` int(11) NOT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `description` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `category_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `sub_categories`
--

INSERT INTO `sub_categories` (`id`, `name`, `description`, `category_id`) VALUES
(2, 'Mặt nạ cho tóc', 'Đắp mặt nạ cho tóc :))', 1),
(3, 'Phụ kiện cho tóc', 'Đeo nơ vào cho tóc kiểu kiểu như thế', 1),
(4, 'Serum dưỡng tóc', 'Chứa dưỡng chất giúp phục hồi hư tổn siêu tốc', 1),
(5, 'Chăm sóc môi', 'Kiểu như son dưỡng', 2),
(6, 'Chăm sóc vùng da mắt', 'Cái miếng dán con con ở mắt', 2),
(8, 'Sữa rửa mặt', 'Rửa cho sạch mặt', 3),
(9, 'Tẩy tế bào chết', 'Tẩy đi có nó để lại nám', 3),
(10, 'Tone/nước hoa hồng', 'Cái nước này thơm cực', 3),
(11, 'Máy rửa mặt', 'Máy xoay xoay , phê phê', 3),
(12, 'Mặt nạ', 'Đắp mọi lúc mọi nươi', 3),
(13, 'Kem dưỡng da ban ngày', 'Kiểu như kem chống nắng', 3),
(14, 'Kem dưỡng da ban đêm', 'Này chắc kem chống tối', 3),
(15, 'Lotion', 'Chịu', 3),
(17, 'Xóa nhăn', ' Giúp lâu già 2', 4),
(18, 'Nâng cơ', 'Nâng cơ ngực', 4),
(19, 'Trị Nám', 'Xóa đi vết nám trên mặt', 4),
(20, 'Trị mụn', 'Bôi tầm 1 năm hết mụn', 4),
(21, 'Trắng da', 'Trắng không tì vết', 4),
(22, 'Dưỡng ẩm', 'Giúp bạn nhìn mọng nước hơn', 4);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `suppliers`
--

CREATE TABLE `suppliers` (
  `id` int(11) NOT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `company_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `logo` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `web_url` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `product_type` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `person_contact` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `address1` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `address2` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `city` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `country` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `postal_code` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `telephone` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `suppliers`
--

INSERT INTO `suppliers` (`id`, `name`, `company_name`, `logo`, `web_url`, `product_type`, `person_contact`, `address1`, `address2`, `city`, `country`, `postal_code`, `telephone`, `email`) VALUES
(1, 'Dầu gội anh quốc', 'CTCP Anh Quốc', 'y-nghia-logo-thuong-hieu-chanel.jpg', 'https://www.chanel.com/vn/?gclid=Cj0KCQjwqoibBhDUARIsAH2OpWhR8bS_t8WdfgTgKh5qolA_fOgH_HAxhMcPz5_3QrUGMNrktG0NrpIaAgiHEALw_wcB', 'Dầu gội', 'Nguyễn Văn A', 'Thôn Công An- Hoàng Văn Thụ-Chương Mỹ', 'Thôn Công An 2- Hoàng Văn Thụ-Chương Mỹ', 'Hà Nội', 'Việt Nam', '46547345', '0965221785', 'duongnvph17448@fpt.edu.vn');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `voucher`
--

CREATE TABLE `voucher` (
  `id` int(11) NOT NULL,
  `discount` float NOT NULL,
  `code` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `voucher_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `create_date` datetime(6) NOT NULL DEFAULT current_timestamp(6),
  `from_time` datetime(6) NOT NULL DEFAULT current_timestamp(6),
  `to_time` datetime(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `voucher`
--

INSERT INTO `voucher` (`id`, `discount`, `code`, `voucher_name`, `create_date`, `from_time`, `to_time`) VALUES
(1, 30000, 'hDP2423Av', 'Mua sản phẩm đầu', '2022-11-02 21:47:15.000000', '2022-11-03 21:47:15.000000', '2022-11-17 21:47:15.000000');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `accounts`
--
ALTER TABLE `accounts`
  ADD PRIMARY KEY (`email`);

--
-- Chỉ mục cho bảng `banner`
--
ALTER TABLE `banner`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `capacities`
--
ALTER TABLE `capacities`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `categories`
--
ALTER TABLE `categories`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `contact`
--
ALTER TABLE `contact`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `discount_product`
--
ALTER TABLE `discount_product`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `favourite`
--
ALTER TABLE `favourite`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `footer`
--
ALTER TABLE `footer`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `news`
--
ALTER TABLE `news`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `order_detail`
--
ALTER TABLE `order_detail`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `payment_history`
--
ALTER TABLE `payment_history`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `sub_categories`
--
ALTER TABLE `sub_categories`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `suppliers`
--
ALTER TABLE `suppliers`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `voucher`
--
ALTER TABLE `voucher`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `banner`
--
ALTER TABLE `banner`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `capacities`
--
ALTER TABLE `capacities`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT cho bảng `categories`
--
ALTER TABLE `categories`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT cho bảng `contact`
--
ALTER TABLE `contact`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `discount_product`
--
ALTER TABLE `discount_product`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT cho bảng `favourite`
--
ALTER TABLE `favourite`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT cho bảng `footer`
--
ALTER TABLE `footer`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `news`
--
ALTER TABLE `news`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `orders`
--
ALTER TABLE `orders`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT cho bảng `order_detail`
--
ALTER TABLE `order_detail`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=53;

--
-- AUTO_INCREMENT cho bảng `payment`
--
ALTER TABLE `payment`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `payment_history`
--
ALTER TABLE `payment_history`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT cho bảng `products`
--
ALTER TABLE `products`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT cho bảng `sub_categories`
--
ALTER TABLE `sub_categories`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT cho bảng `suppliers`
--
ALTER TABLE `suppliers`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT cho bảng `voucher`
--
ALTER TABLE `voucher`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
