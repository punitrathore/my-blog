(ns my-blog.layout
 (:use hiccup.core))

(defn wrap-with-layout [page-html]
  (html
   [:html
    [:head
     [:title "Punit Rathore's Blog"]
     [:link {:type "application/rss+xml" :rel "alternate" :href "/feed"}]]
    [:body
     [:div#content
      page-html]]]))
