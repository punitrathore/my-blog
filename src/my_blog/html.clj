(ns my-blog.html   
  (:use (hiccup [core :only [html escape-html]]
                [page-helpers :only [link-to]]
                [form-helpers :only [form-to text-field text-area hidden-field label]]))
  (:require [my-blog.helpers :as helpers]))

(defn render-post [post]
  (if post
    (html [:div.post
           [:h2.title (str (:title post))]
           [:div.post-body
            (str (:body post))]])
    (html "Post not found!")))

(defn new-post-form []
  (html
   [:div#new-post
    (form-to [:post (str "/posts")]
             (helpers/form-row "Title" "title" text-field "large-text-field")
             (helpers/form-row "Body" "body" text-area "large-text-area")
             (helpers/submit-row "Create")
             )]))
