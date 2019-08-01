package app.clinkApi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import app.clinkApi.model.FileModel;



@Transactional
public interface FileRepository extends JpaRepository<FileModel, Long>{	
	
	@Query("SELECT name FROM FileModel p")
    public List<String> getNames();
}