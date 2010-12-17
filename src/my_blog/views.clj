(ns my-blog.views
  (:use hiccup.core)
  (:require [my-blog.post :as p]            
            [my-blog.layout :as layout]
            [my-blog.html :as html]
            [my-blog.comment :as c]
            [ring.util [response :as response]]))


(defn index-page []
  (layout/wrap-with-layout (map html/render-post (p/find-all-posts))))

(defn new-post-page []
  (layout/wrap-with-layout (html/new-post-form)))

(defn create-new-post [attrs]
  (layout/wrap-with-layout (html/render-post (p/create-post attrs))))

(defn create-new-comment [attrs]    
  (let [comment (c/create-comment attrs) post (c/find-post comment)]  
    (response/redirect (str "/posts/" (:id post)))))
