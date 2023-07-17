package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Notification;
import com.repository.NotificationRepository;

@CrossOrigin
@RequestMapping("/api/v1")
@RestController
public class NotificationController {

	@Autowired
	private NotificationRepository nr;

	@PostMapping("/post")
	public ResponseEntity<Notification> postNotification(@RequestBody Notification notification) {
		nr.save(notification);
		return new ResponseEntity<Notification>(notification, HttpStatus.CREATED);
	}

	@GetMapping("/getAll")
	public List<Notification> getAllNotification() {
		return nr.findAll();
	}

	@GetMapping("/getByDestinatario/{destinatario}")
	public List<Notification> getNotificationByDestinatario(@PathVariable Integer destinatario) {
		return nr.findByDestinatario(destinatario);
	}

	@PatchMapping("/patch")
	public ResponseEntity<Notification> patchNotification(@RequestBody Notification notification) {
		Optional<Notification> n = nr.findById(notification.getId());
		n.get().setStatus(notification.getStatus());
		nr.save(n.get());
		return new ResponseEntity<Notification>(n.get(), HttpStatus.CREATED);
	}
}
