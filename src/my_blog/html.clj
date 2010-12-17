(ns my-blog.html   
  (:use (hiccup [core :only [html escape-html]]
                [page-helpers :only [link-to]]
                [form-helpers :only [form-to text-field text-area hidden-field label]]))
  (:require [my-blog.helpers :as helpers]
            [my-blog.post :as p]
            [my-blog.comment :as c]))

(defn render-comment [comment]
  (if comment
    (html [:div.comment
           [:div.comment-author (str (:author comment))]
           [:div.comment-body (str (:body comment))]])))

(defn new-comment-form [post]
  (html
   [:div#new-comment
    (form-to [:post (str "/comments")]
             (helpers/form-row "Author" "author" text-field "comment-text-field")
             (helpers/form-row "Body" "body" text-area "comment-text-area")
             (hidden-field "post_id" (:id post))
             (helpers/submit-row "Post Comment"))]))

(defn render-post [post]  
    (html [:div.post
           [:h3.title  (link-to (helpers/posts-path post) (str (:title post)))]
           [:div.post-body
            (str (:body post))]
           ]))


(defn render-full-post [post]
  (if post    
    (html
     (render-post post)
     [:br]
     [:div#comments
      [:h4 "Displaying Comments"]
      (map render-comment (p/find-comments post))]
     [:br]
     (new-comment-form post))))

(defn new-post-form []
  (html
   [:div#new-post
    (form-to [:post (str "/posts")]
             (helpers/form-row "Title" "title" text-field "large-text-field")
             (helpers/form-row "Body" "body" text-area "large-text-area")
             (helpers/submit-row "Create"))]))
