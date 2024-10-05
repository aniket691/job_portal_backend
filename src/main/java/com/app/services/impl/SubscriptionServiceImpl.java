package com.app.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.SubscriptionDTO;
import com.app.entity.Subscription;
import com.app.repository.SubscriptionRepository;
import com.app.service.SubscriptionService;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public SubscriptionDTO createSubscription(SubscriptionDTO subscriptionDTO) {
        Subscription subscription = modelMapper.map(subscriptionDTO, Subscription.class);
        Subscription savedSubscription = subscriptionRepository.save(subscription);
        return modelMapper.map(savedSubscription, SubscriptionDTO.class);
    }

    @Override
    public SubscriptionDTO getSubscriptionById(Long subscriptionId) {
        Subscription subscription = subscriptionRepository.findById(subscriptionId)
                .orElseThrow(() -> new EntityNotFoundException("Subscription not found"));
        return modelMapper.map(subscription, SubscriptionDTO.class);
    }

    @Override
    public List<SubscriptionDTO> getAllSubscriptions() {
        List<Subscription> subscriptions = subscriptionRepository.findAll();
        return subscriptions.stream()
                .map(subscription -> modelMapper.map(subscription, SubscriptionDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public SubscriptionDTO updateSubscription(Long subscriptionId, SubscriptionDTO subscriptionDTO) {
        Subscription subscription = subscriptionRepository.findById(subscriptionId)
                .orElseThrow(() -> new EntityNotFoundException("Subscription not found"));
        subscription.setSubscriptionType(subscriptionDTO.getSubscriptionType());
        subscription.setSubscriptionStartDate(subscriptionDTO.getSubscriptionStartDate());
        subscription.setSubscriptionEndDate(subscriptionDTO.getSubscriptionEndDate());
        Subscription updatedSubscription = subscriptionRepository.save(subscription);
        return modelMapper.map(updatedSubscription, SubscriptionDTO.class);
    }

    @Override
    public void deleteSubscription(Long subscriptionId) {
        Subscription subscription = subscriptionRepository.findById(subscriptionId)
                .orElseThrow(() -> new EntityNotFoundException("Subscription not found"));
        subscriptionRepository.delete(subscription);
    }
}
