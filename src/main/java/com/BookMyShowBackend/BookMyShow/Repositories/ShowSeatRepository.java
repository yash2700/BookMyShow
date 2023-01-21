package com.BookMyShowBackend.BookMyShow.Repositories;

import com.BookMyShowBackend.BookMyShow.Models.ShowSeatEntity;
import org.hibernate.sql.ast.tree.expression.JdbcParameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeatEntity,Integer> {
}
