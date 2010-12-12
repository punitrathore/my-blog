(ns my-blog.html   
  (:use hiccup.core))

(defn render-post [post]
  (if post
    (html [:div.post
           [:h2.title (str (:title post))]
           [:div.post-body
            (str (:body post))]])
    (html "Post not found!")))
