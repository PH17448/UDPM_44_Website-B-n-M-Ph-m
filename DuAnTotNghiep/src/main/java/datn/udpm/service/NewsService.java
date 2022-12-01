package datn.udpm.service;

import java.util.List;

import datn.udpm.entity.News;

public interface NewsService {

	List<News> findAll();

	News save(News news);

	News findById(Integer id);

	void delete(News result);

}
