package datn.udpm.service.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import datn.udpm.entity.News;
import datn.udpm.respository.NewsRespository;
import datn.udpm.service.NewsService;
@Service
public class NewsServiceImple implements NewsService {

	@Autowired
	NewsRespository newRespository ;
	
	@Override
	public List<News> findAll() {
		return newRespository.findAll();
	}

	@Override
	public News save(News news) {
		return newRespository.save(news);
	}

	@Override
	public News findById(Integer id) {
		return newRespository.findById(id).get();
	}

	@Override
	public void delete(News result) {
		newRespository.delete(result);
	}

}
