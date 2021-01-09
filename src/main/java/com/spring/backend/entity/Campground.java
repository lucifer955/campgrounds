package com.spring.backend.entity;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "campground")
public class Campground {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "campground_name")
    private String campground_name;

    @Column(name = "campground_img")
    private String campground_img;

    @Column(name = "campground_desc")
    private String campground_desc;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey(name = "uc_fid"), name = "uc_fid")
    private UserProfile userProfile;

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name = "campground_tags",
        joinColumns = { @JoinColumn(name = "camground_id")},
            inverseJoinColumns = {@JoinColumn(name = "tag_id")})
    private Set<Tag> tags = new HashSet<>();

    public Campground() {

    }

    public Campground(String campground_name, String campground_img, String campground_desc, UserProfile userProfile) {
        this.campground_name = campground_name;
        this.campground_img = campground_img;
        this.campground_desc = campground_desc;
        this.userProfile = userProfile;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCampground_name() {
        return campground_name;
    }

    public void setCampground_name(String campground_name) {
        this.campground_name = campground_name;
    }

    public String getCampground_img() {
        return campground_img;
    }

    public void setCampground_img(String campground_img) {
        this.campground_img = campground_img;
    }

    public String getCampground_desc() {
        return campground_desc;
    }

    public void setCampground_desc(String campground_desc) {
        this.campground_desc = campground_desc;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }
}
