package com.spring.backend.service;

import com.spring.backend.entity.Campground;
import com.spring.backend.entity.User;
import com.spring.backend.entity.UserProfile;
import com.spring.backend.repository.CampgroundRepository;
import com.spring.backend.repository.UserProfileRepository;
//import com.spring.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CampgroundService {

    @Autowired
    private CampgroundRepository campgroundRepository;

    @Autowired
    private UserProfileRepository userProfileRepository;

    public List<Campground> getAllCampgrounds() {
        return campgroundRepository.findAll();
    }

    public Campground getCampground(Long id) {
        Optional<Campground> optionalCampground = campgroundRepository.findById(id);
        if(optionalCampground.isPresent()) {
            return optionalCampground.get();
        }
        return null;
    }

    public Campground createCampground(Campground campground) {
        UserProfile userProfile = userProfileRepository.findById(campground.getUserProfile().getId()).orElse(null);
        if(null == userProfile) {
            userProfile = new UserProfile();
        }
        userProfile.setId(campground.getUserProfile().getId());
        campground.setUserProfile(userProfile);
        return campgroundRepository.save(campground);
    }

    public Campground updateCampground(Campground campground) {
        return campgroundRepository.save(campground);
    }

    public void deleteCampground(Long campgroundId) {
        campgroundRepository.deleteById(campgroundId);
    }
}
