package org.codeforafrica.citizenreporter.starreports.models;

import android.text.TextUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.wordpress.android.util.AppLog;
import org.wordpress.android.util.AppLog.T;
import org.wordpress.android.util.StringUtils;

import java.io.Serializable;

public class Post implements Serializable {
    // Increment this value if this model changes
    // See: http://www.javapractices.com/topic/TopicAction.do?Id=45
    static final long serialVersionUID  = 2L;

    public static String QUICK_MEDIA_TYPE_PHOTO = "QuickPhoto";

    private long localTablePostId;
    private int localTableBlogId;
    private String categories;
    private String customFields;
    private long dateCreated;
    private long dateCreatedGmt;
    private String description;
    private String link;
    private boolean allowComments;
    private boolean allowPings;
    private String excerpt;
    private String keywords;
    private String moreText;
    private String permaLink;
    private String status;
    private String remotePostId;
    private String title;
    private String userId;
    private String authorDisplayName;
    private String authorId;
    private String password;
    private String postFormat;
    private String slug;
    private String location;
    private String bounty;
    private String media_types;
    private String deadline;
    private boolean localDraft;
    private boolean uploaded;
    private boolean mIsUploading;
    private boolean mChangedFromLocalDraftToPublished;
    private boolean isPage;
    private String pageParentId;
    private String pageParentTitle;
    private boolean isLocalChange;
    private String mediaPaths;
    private String quickPostType;
    private int assignment_id;
    private PostLocation mPostLocation;
    private String remoteMediaPaths;

    private String assignmentLocation;
    private String assignmnetBounty;
    private String assignmentMediaTypes;
    private String assignmentDeadline;
    private String coordinates;

    private String qwhy;
    private String qwhen;
    private String qhow;

    public String getQwhen_date() {
        return qwhen_date;
    }

    public void setQwhen_date(String qwhen_date) {
        this.qwhen_date = qwhen_date;
    }

    private String qwhen_date;

    public String getOwn_price() {
        return own_price;
    }

    public void setOwn_price(String own_price) {
        this.own_price = own_price;
    }

    private String own_price;

    public String getRemoteMediaPaths() {
        return remoteMediaPaths;
    }

    public void setRemoteMediaPaths(String remoteMediaPaths) {
        this.remoteMediaPaths = remoteMediaPaths;
    }


    public Post() {
    }

    public Post(int blogId, boolean isPage) {
        // creates a new, empty post for the passed in blogId
        this.localTableBlogId = blogId;
        this.isPage = isPage;
        this.localDraft = true;
    }

    public long getLocalTablePostId() {
        return localTablePostId;
    }

    public long getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(long dateCreated) {
        this.dateCreated = dateCreated;
    }

    public long getDate_created_gmt() {
        return dateCreatedGmt;
    }

    public void setDate_created_gmt(long dateCreatedGmt) {
        this.dateCreatedGmt = dateCreatedGmt;
    }

    public void setCategories(String postCategories) {
        this.categories = postCategories;
    }

    public void setCustomFields(String customFields) {
        this.customFields = customFields;
    }

    public int getLocalTableBlogId() {
        return localTableBlogId;
    }

    public void setLocalTableBlogId(int localTableBlogId) {
        this.localTableBlogId = localTableBlogId;
    }

    public boolean isLocalDraft() {
        return localDraft;
    }

    public void setLocalDraft(boolean localDraft) {
        this.localDraft = localDraft;
    }

    public JSONArray getJSONCategories() {
        return null;
/*
        JSONArray jArray = null;

        if (categories == null) {
            categories = "[]";
        }
        try {
            categories = StringUtils.unescapeHTML(categories);
            if (TextUtils.isEmpty(categories)) {
                jArray = new JSONArray();
            } else {
                jArray = new JSONArray(categories);
            }
        } catch (JSONException e) {
            AppLog.e(T.POSTS, e);
        }
        return jArray;*/
    }

    public void setJSONCategories(JSONArray categories) {
//        this.categories = categories.toString();
    }

    public JSONArray getCustomFields() {
        if (customFields == null) {
            return null;
        }
        JSONArray jArray = null;
        try {
            jArray = new JSONArray(customFields);
        } catch (JSONException e) {
            AppLog.e(T.POSTS, "No custom fields found for post.");
        }
        return jArray;
    }

    public JSONObject getCustomField(String key) {
        JSONArray customFieldsJson = getCustomFields();
        if (customFieldsJson == null) {
            return null;
        }

        for (int i = 0; i < customFieldsJson.length(); i++) {
            try {
                JSONObject jsonObject = new JSONObject(customFieldsJson.getString(i));
                String curentKey = jsonObject.getString("key");
                if (key.equals(curentKey)) {
                    return jsonObject;
                }
            } catch (JSONException e) {
                AppLog.e(T.POSTS, e);
            }
        }
        return null;
    }

    public void setCustomFields(JSONArray customFields) {
        this.customFields = customFields.toString();
    }

    public String getDescription() {
        return StringUtils.notNullStr(description);
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return StringUtils.notNullStr(link);
    }

    public void setLink(String link) {
        this.link = link;
    }

    public boolean isAllowComments() {
        return allowComments;
    }

    public void setAllowComments(boolean mtAllowComments) {
        allowComments = mtAllowComments;
    }

    public boolean isAllowPings() {
        return allowPings;
    }

    public void setAllowPings(boolean mtAllowPings) {
        allowPings = mtAllowPings;
    }

    public String getPostExcerpt() {
        return StringUtils.notNullStr(excerpt);
    }

    public void setPostExcerpt(String mtExcerpt) {
        excerpt = mtExcerpt;
    }

    public String getKeywords() {
            return StringUtils.notNullStr(keywords);
    }

    public void setKeywords(String mtKeywords) {
        keywords = mtKeywords;
    }

    public String getMoreText() {
        return StringUtils.notNullStr(moreText);
    }

    public void setMoreText(String mtTextMore) {
        moreText = mtTextMore;
    }

    public String getPermaLink() {
        return StringUtils.notNullStr(permaLink);
    }

    public void setPermaLink(String permaLink) {
        this.permaLink = permaLink;
    }

    public String getPostStatus() {
        return StringUtils.notNullStr(status);
    }

    public void setPostStatus(String postStatus) {
        status = postStatus;
    }

    public PostStatus getStatusEnum() {
        return PostStatus.fromPost(this);
    }

    public String getRemotePostId() {
        return StringUtils.notNullStr(remotePostId);
    }

    public void setRemotePostId(String postId) {
        this.remotePostId = postId;
    }

    public String getTitle() {
        return StringUtils.notNullStr(title);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    public void setBounty(String bounty) {
        this.bounty = bounty;
    }
    public void setMedia_types(String media_types) {
        this.media_types = media_types;
    }
    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getStringLocation() {
        return location;
    }

    public void setStringLocation(String _location) {
        this.location = _location;
    }
    public String getBounty() {
        return bounty;
    }

    public String getMedia_types() {
        return media_types;
    }
    public String getDeadline() {
        return deadline;
    }

    public String getUserId() {
        return StringUtils.notNullStr(userId);
    }

    public void setUserId(String userid) {
        this.userId = userid;
    }

    public String getAuthorDisplayName() {
        return StringUtils.notNullStr(authorDisplayName);
    }

    public void setAuthorDisplayName(String wpAuthorDisplayName) {
        authorDisplayName = wpAuthorDisplayName;
    }

    public String getAuthorId() {
        return StringUtils.notNullStr(authorId);
    }

    public void setAuthorId(String wpAuthorId) {
        authorId = wpAuthorId;
    }

    public String getPassword() {
        return StringUtils.notNullStr(password);
    }

    public void setPassword(String wpPassword) {
        password = wpPassword;
    }

    public String getPostFormat() {
        return StringUtils.notNullStr(postFormat);
    }

    public void setPostFormat(String wpPostForm) {
        postFormat = wpPostForm;
    }

    public String getSlug() {
        return StringUtils.notNullStr(slug);
    }

    public void setSlug(String wpSlug) {
        slug = wpSlug;
    }

    public String getMediaPaths() {
        return StringUtils.notNullStr(mediaPaths);
    }

    public void setMediaPaths(String mediaPaths) {
        this.mediaPaths = mediaPaths;
    }

    public boolean supportsLocation() {
        // Right now, we only disable for pages.
        return !isPage();
    }

    public boolean hasLocation() {
        return mPostLocation != null && mPostLocation.isValid();
    }

    public PostLocation getLocation() {
        return mPostLocation;
    }

    public void setLocation(PostLocation location) {
        mPostLocation = location;
    }

    public void unsetLocation() {
        mPostLocation = null;
    }

    public void setLocation(double latitude, double longitude) {
        try {
            mPostLocation = new PostLocation(latitude, longitude);
        } catch (IllegalArgumentException e) {
            mPostLocation = null;
            AppLog.e(T.POSTS, e);
        }
    }

    public boolean isPage() {
        return isPage;
    }

    public void setIsPage(boolean isPage) {
        this.isPage = isPage;
    }

    public String getPageParentId() {
        return StringUtils.notNullStr(pageParentId);
    }

    public void setPageParentId(String wp_page_parent_id) {
        this.pageParentId = wp_page_parent_id;
    }

    public String getPageParentTitle() {
        return StringUtils.notNullStr(pageParentTitle);
    }

    public void setPageParentTitle(String wp_page_parent_title) {
        this.pageParentTitle = wp_page_parent_title;
    }

    public boolean isUploading() {
        return mIsUploading;
    }

    public void setUploading(boolean uploading) {
        this.mIsUploading = uploading;
    }

    public boolean isUploaded() {
        return uploaded;
    }

    public void setUploaded(boolean uploaded) {
        this.uploaded = uploaded;
    }

    public boolean isLocalChange() {
        return isLocalChange;
    }

    public void setLocalChange(boolean isLocalChange) {
        this.isLocalChange = isLocalChange;
    }

    public void setLocalTablePostId(long id) {
        this.localTablePostId = id;
    }

    public void setQuickPostType(String type) {
        this.quickPostType = type;
    }

    public String getQuickPostType() {
        return StringUtils.notNullStr(quickPostType);
    }

    /**
     * This indicates if the post has changed from a draft to published. This is primarily used
     * for stats tracking purposes as we want to ensure that we properly track certain things when
     * the user first publishes a post
     * @return
     */
    public boolean hasChangedFromLocalDraftToPublished() {
        return mChangedFromLocalDraftToPublished;
    }

    public void setChangedFromLocalDraftToPublished(boolean changedFromLocalDraftToPublished) {
        this.mChangedFromLocalDraftToPublished = changedFromLocalDraftToPublished;
    }

    /**
     * Checks if this post currently has data differing from another post.
     *
     * @param otherPost The post to compare to this post's editable data.
     * @return True if this post's data differs from otherPost's data, False otherwise.
     */
    public boolean hasChanges(Post otherPost) {
        return otherPost == null || !(StringUtils.equals(title, otherPost.title) &&
                                      StringUtils.equals(description, otherPost.description) &&
                                      StringUtils.equals(excerpt, otherPost.excerpt) &&
                                      StringUtils.equals(keywords, otherPost.keywords) &&
                                      StringUtils.equals(categories, otherPost.categories) &&
                                      StringUtils.equals(status, otherPost.status) &&
                                      StringUtils.equals(password, otherPost.password) &&
                                      StringUtils.equals(postFormat, otherPost.postFormat) &&
                                      this.dateCreatedGmt == otherPost.dateCreatedGmt &&
                                      PostLocation.equals(this.mPostLocation, otherPost.mPostLocation)
        );
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + localTableBlogId;
        result = prime * result + (int) (localTablePostId ^ (localTablePostId >>> 32));
        result = prime * result + (isPage ? 1231 : 1237);
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this)
            return true;
        if (other instanceof Post) {
            Post otherPost = (Post) other;
            return (this.localTablePostId == otherPost.localTablePostId &&
                    this.isPage == otherPost.isPage &&
                    this.localTableBlogId == otherPost.localTableBlogId
            );
        } else {
            return false;
        }
    }

    /**
     * Get the entire post content
     * Joins description and moreText fields if both are valid
     * @return post content as String
     */
    public String getContent() {
        String postContent;
        if (!TextUtils.isEmpty(getMoreText())) {
            if (isLocalDraft()) {
                postContent = getDescription() + "\n&lt;!--more--&gt;\n" + getMoreText();
            } else {
                postContent = getDescription() + "\n<!--more-->\n" + getMoreText();
            }
        } else {
            postContent = getDescription();
        }

        return postContent;
    }

    public boolean isPublished() {
        return !getRemotePostId().isEmpty();
    }

    public boolean isPublishable() {
        return !(getContent().isEmpty() && getPostExcerpt().isEmpty() && getTitle().isEmpty());
    }

    public int getAssignment_id() {
        return assignment_id;
    }

    public void setAssignment_id(int assignment_id) {
        this.assignment_id = assignment_id;
    }

    public String getAssignmentLocation() {
        return assignmentLocation;
    }

    public void setAssignmentLocation(String assignmentLocation) {
        this.assignmentLocation = assignmentLocation;
    }

    public String getAssignmnetBounty() {
        return assignmnetBounty;
    }

    public void setAssignmnetBounty(String assignmnetBounty) {
        this.assignmnetBounty = assignmnetBounty;
    }

    public String getAssignmentMediaTypes() {
        return assignmentMediaTypes;
    }

    public void setAssignmentMediaTypes(String assignmentMediaTypes) {
        this.assignmentMediaTypes = assignmentMediaTypes;
    }

    public String getAssignmentDeadline() {
        return assignmentDeadline;
    }

    public void setAssignmentDeadline(String assignmentDeadline) {
        this.assignmentDeadline = assignmentDeadline;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    public String getQwhy() {
        return qwhy;
    }

    public void setQwhy(String qwhy) {
        this.qwhy = qwhy;
    }


    public String getQwhen() {
        return qwhen;
    }

    public void setQwhen(String qwhen) {
        this.qwhen = qwhen;
    }

    public String getQhow() {
        return qhow;
    }

    public void setQhow(String qhow) {
        this.qhow = qhow;
    }
}
