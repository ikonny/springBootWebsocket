package cn.hkfdt.xiaot.mybatis.model.ltschina;

import java.io.Serializable;
import java.util.Date;

public class Auth implements Serializable {
    private String userid;

    private String email;

    private String username;

    private String password;

    private String salt;

    private String phone;

    private Date created;

    private Byte usertype;

    private String country;

    private String language;

    private Byte userlevel;

    private Byte isterminated;

    private String school;

    private String service;

    private String firstname;

    private String lastname;

    private String location;

    private String org;

    private String sex;

    private String birthday;

    private Long schoolId;

    private String schoolKey;

    private String schoolRegion;

    private String schoolName;

    private String isBlocked;

    private String isActive;

    private String blacklistRanking;

    private String servingUrl;

    private String imageWidth;

    private String imageHeight;

    private String forgetPassword;

    private String publishTime;

    private String lastUpdateTime;

    private String openid;

    private String unionid;

    private String city;

    private String province;

    private String wechatPrivilege;

    private String qqVip;

    private String phoneCountry;

    private String identity;

    private Date passChangedTime;

    private String permission;

    private String ebrokerId;

    private String bio;

    private String backgroundUrl;

    private static final long serialVersionUID = 1L;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Byte getUsertype() {
        return usertype;
    }

    public void setUsertype(Byte usertype) {
        this.usertype = usertype;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language == null ? null : language.trim();
    }

    public Byte getUserlevel() {
        return userlevel;
    }

    public void setUserlevel(Byte userlevel) {
        this.userlevel = userlevel;
    }

    public Byte getIsterminated() {
        return isterminated;
    }

    public void setIsterminated(Byte isterminated) {
        this.isterminated = isterminated;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school == null ? null : school.trim();
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service == null ? null : service.trim();
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname == null ? null : firstname.trim();
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname == null ? null : lastname.trim();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org == null ? null : org.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday == null ? null : birthday.trim();
    }

    public Long getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Long schoolId) {
        this.schoolId = schoolId;
    }

    public String getSchoolKey() {
        return schoolKey;
    }

    public void setSchoolKey(String schoolKey) {
        this.schoolKey = schoolKey == null ? null : schoolKey.trim();
    }

    public String getSchoolRegion() {
        return schoolRegion;
    }

    public void setSchoolRegion(String schoolRegion) {
        this.schoolRegion = schoolRegion == null ? null : schoolRegion.trim();
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName == null ? null : schoolName.trim();
    }

    public String getIsBlocked() {
        return isBlocked;
    }

    public void setIsBlocked(String isBlocked) {
        this.isBlocked = isBlocked == null ? null : isBlocked.trim();
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive == null ? null : isActive.trim();
    }

    public String getBlacklistRanking() {
        return blacklistRanking;
    }

    public void setBlacklistRanking(String blacklistRanking) {
        this.blacklistRanking = blacklistRanking == null ? null : blacklistRanking.trim();
    }

    public String getServingUrl() {
        return servingUrl;
    }

    public void setServingUrl(String servingUrl) {
        this.servingUrl = servingUrl == null ? null : servingUrl.trim();
    }

    public String getImageWidth() {
        return imageWidth;
    }

    public void setImageWidth(String imageWidth) {
        this.imageWidth = imageWidth == null ? null : imageWidth.trim();
    }

    public String getImageHeight() {
        return imageHeight;
    }

    public void setImageHeight(String imageHeight) {
        this.imageHeight = imageHeight == null ? null : imageHeight.trim();
    }

    public String getForgetPassword() {
        return forgetPassword;
    }

    public void setForgetPassword(String forgetPassword) {
        this.forgetPassword = forgetPassword == null ? null : forgetPassword.trim();
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime == null ? null : publishTime.trim();
    }

    public String getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(String lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime == null ? null : lastUpdateTime.trim();
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid == null ? null : unionid.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getWechatPrivilege() {
        return wechatPrivilege;
    }

    public void setWechatPrivilege(String wechatPrivilege) {
        this.wechatPrivilege = wechatPrivilege == null ? null : wechatPrivilege.trim();
    }

    public String getQqVip() {
        return qqVip;
    }

    public void setQqVip(String qqVip) {
        this.qqVip = qqVip == null ? null : qqVip.trim();
    }

    public String getPhoneCountry() {
        return phoneCountry;
    }

    public void setPhoneCountry(String phoneCountry) {
        this.phoneCountry = phoneCountry == null ? null : phoneCountry.trim();
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity == null ? null : identity.trim();
    }

    public Date getPassChangedTime() {
        return passChangedTime;
    }

    public void setPassChangedTime(Date passChangedTime) {
        this.passChangedTime = passChangedTime;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission == null ? null : permission.trim();
    }

    public String getEbrokerId() {
        return ebrokerId;
    }

    public void setEbrokerId(String ebrokerId) {
        this.ebrokerId = ebrokerId == null ? null : ebrokerId.trim();
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio == null ? null : bio.trim();
    }

    public String getBackgroundUrl() {
        return backgroundUrl;
    }

    public void setBackgroundUrl(String backgroundUrl) {
        this.backgroundUrl = backgroundUrl == null ? null : backgroundUrl.trim();
    }
}