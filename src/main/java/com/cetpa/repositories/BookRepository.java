package com.cetpa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.cetpa.models.Book;
import com.cetpa.models.BookCategory;

public interface BookRepository extends JpaRepository<Book,Integer> 
{
	List<Book> findByAuthor(String author); 
	@Query("from Book where price between :price1 and :price2")
	List<Book> findByPriceRange(@Param("price1") int p1,@Param("price2") int p2);
	//List<Book> findByCatId(BookCategory category); 
	@Query("select b from Book b join BookCategory bk on b.category=bk.catid where bk.category=:cat")
	List<Book> findByCategory(@Param("cat") String cat);
	@Transactional
	@Modifying
	@Query("update Book set copies=copies+:cpy where bookid=:bid")
	int increaseCopies(@Param("cpy") int cpy,@Param("bid") int bid);
	
	@Transactional
	@Modifying
	@Query("update Book set copies=copies-:cpy where bookid=:bid")
	int decreaseCopies(@Param("cpy") int cpy,@Param("bid") int bid);
}
