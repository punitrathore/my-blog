(ns my-blog.layout
;;  (:use hiccup.core)
;;  (:use hiccup.form-helpers)
    (:use (hiccup [core :only [html escape-html]]
                [page-helpers :only [link-to]]
                [form-helpers :only [form-to text-field text-area hidden-field]])))

(defn wrap-with-layout [page-html]
  (html
   [:html
    [:head
     [:title "Punit Rathore's Blog"]
     [:link {:type "application/rss+xml" :rel "alternate" :href "/feed"}]]
    [:body
     [:div#header
      [:h1 "Welcome to Punit's blog!"]
       [:span.header-link (link-to "/posts" "Home")]
      [:span.header-link (link-to "/posts/new" "New Post")]]
     [:div#content
      page-html]]]))
