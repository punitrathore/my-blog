(ns my-blog.views
  (:use hiccup.core)
  (:require [my-blog.post :as post]            
            [my-blog.layout :as layout]
            [my-blog.html :as html]))


(defn index-page []
  (layout/wrap-with-layout (map html/render-post (post/find-all-posts))))

(defn new-post-page []
  (layout/wrap-with-layout (html/new-post-form)))

(defn create-new-post [attrs]
  (layout/wrap-with-layout (html/render-post (post/create-post attrs))))
