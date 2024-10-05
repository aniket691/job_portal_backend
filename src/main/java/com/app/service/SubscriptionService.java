package com.app.service;

import com.app.dto.SubscriptionDTO;
import java.util.List;

public interface SubscriptionService {
    SubscriptionDTO createSubscription(SubscriptionDTO subscriptionDTO);
    SubscriptionDTO getSubscriptionById(Long subscriptionId);
    List<SubscriptionDTO> getAllSubscriptions();
    SubscriptionDTO updateSubscription(Long subscriptionId, SubscriptionDTO subscriptionDTO);
    void deleteSubscription(Long subscriptionId);
}
