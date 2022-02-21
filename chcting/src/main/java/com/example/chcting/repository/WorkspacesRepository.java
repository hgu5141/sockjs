package com.example.chcting.repository;

import com.example.chcting.model.User;
import com.example.chcting.model.Workspaces;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkspacesRepository extends JpaRepository<Workspaces, Long> {
    List<Workspaces> findAllByOrderByCreatedAtDesc();
}