package com.OrlandoDilmarGareca.socialapp.retrofit.Response;
//
//import com.google.gson.annotations.Expose;
//import com.google.gson.annotations.SerializedName;
//
//public class ResponseAuth {
//
//    @SerializedName("token")
//    @Expose
//    private String token;
//    @SerializedName("username")
//    @Expose
//    private String username;
//    @SerializedName("email")
//    @Expose
//    private String email;
//    @SerializedName("photoUrl")
//    @Expose
//    private String photoUrl;
//    @SerializedName("created")
//    @Expose
//    private String created;
//    @SerializedName("active")
//    @Expose
//    private Boolean active;
//
//    /**
//     * No args constructor for use in serialization
//     *
//     */
//    public ResponseAuth() {
//    }
//
//    /**
//     *
//     * @param photoUrl
//     * @param created
//     * @param active
//     * @param email
//     * @param token
//     * @param username
//     */
//    public ResponseAuth(String token, String username, String email, String photoUrl, String created, Boolean active) {
//        super();
//        this.token = token;
//        this.username = username;
//        this.email = email;
//        this.photoUrl = photoUrl;
//        this.created = created;
//        this.active = active;
//    }
//
//    public String getToken() {
//        return token;
//    }
//
//    public void setToken(String token) {
//        this.token = token;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getPhotoUrl() {
//        return photoUrl;
//    }
//
//    public void setPhotoUrl(String photoUrl) {
//        this.photoUrl = photoUrl;
//    }
//
//    public String getCreated() {
//        return created;
//    }
//
//    public void setCreated(String created) {
//        this.created = created;
//    }
//
//    public Boolean getActive() {
//        return active;
//    }
//
//    public void setActive(Boolean active) {
//        this.active = active;
//    }
//
//}

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseAuth {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("last_login")
    @Expose
    private Object lastLogin;
    @SerializedName("is_superuser")
    @Expose
    private Boolean isSuperuser;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("last_name")
    @Expose
    private String lastName;
    @SerializedName("image")
    @Expose
    private Object image;
    @SerializedName("is_active")
    @Expose
    private Boolean isActive;
    @SerializedName("is_staff")
    @Expose
    private Boolean isStaff;
    @SerializedName("groups")
    @Expose
    private List<Object> groups = null;
    @SerializedName("user_permissions")
    @Expose
    private List<Object> userPermissions = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public ResponseAuth() {
    }

    /**
     *
     * @param lastLogin
     * @param lastName
     * @param image
     * @param isStaff
     * @param isSuperuser
     * @param groups
     * @param userPermissions
     * @param isActive
     * @param password
     * @param name
     * @param id
     * @param email
     * @param username
     */
    public ResponseAuth(Integer id, String password, Object lastLogin, Boolean isSuperuser, String username, String email, String name, String lastName, Object image, Boolean isActive, Boolean isStaff, List<Object> groups, List<Object> userPermissions) {
        super();
        this.id = id;
        this.password = password;
        this.lastLogin = lastLogin;
        this.isSuperuser = isSuperuser;
        this.username = username;
        this.email = email;
        this.name = name;
        this.lastName = lastName;
        this.image = image;
        this.isActive = isActive;
        this.isStaff = isStaff;
        this.groups = groups;
        this.userPermissions = userPermissions;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Object getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Object lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Boolean getIsSuperuser() {
        return isSuperuser;
    }

    public void setIsSuperuser(Boolean isSuperuser) {
        this.isSuperuser = isSuperuser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Object getImage() {
        return image;
    }

    public void setImage(Object image) {
        this.image = image;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Boolean getIsStaff() {
        return isStaff;
    }

    public void setIsStaff(Boolean isStaff) {
        this.isStaff = isStaff;
    }

    public List<Object> getGroups() {
        return groups;
    }

    public void setGroups(List<Object> groups) {
        this.groups = groups;
    }

    public List<Object> getUserPermissions() {
        return userPermissions;
    }

    public void setUserPermissions(List<Object> userPermissions) {
        this.userPermissions = userPermissions;
    }

}