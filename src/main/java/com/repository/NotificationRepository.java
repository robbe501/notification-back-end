package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Integer> {
	public List<Notification> findByDestinatario(Integer destinatario);
}
