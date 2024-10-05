package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.Subscription;

public interface SubscriptionRepository extends JpaRepository<Subscription,Long> {

}
