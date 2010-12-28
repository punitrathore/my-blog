(ns my-blog.layout
  (:use (hiccup [core :only [html escape-html]]
                [page-helpers :only [link-to include-css include-js]]
                [form-helpers :only [form-to text-field text-area hidden-field]])))

(defn wrap-with-layout [page-html]
  (html
   [:html
    [:head
     [:title "Punit Rathore's Blog"]
     [:link {:type "application/rss+xml" :rel "alternate" :href "/feed"}]
     (include-css "/css/yui/base-min.css")
     (include-css "/css/yui/reset-min.css")
     (include-css "/css/yui/fonts-min.css")
     (include-css "/css/yui/grids-min.css")     
     (include-css "/css/common.css")]
    [:body
     [:div#hd
      [:h1 "Welcome to Punit's blog!"]
       [:span.header-link (link-to "/posts" "Home")]
      [:span.header-link (link-to "/posts/new" "New Post")]]
     [:div#doc4.yui-t4
      [:div#bd
       
       [:div#main-page.yui-ge
        [:div#content-container.yui-u.first
        [:div#content
         page-html]]
       [:div#sidebar.yui-u
        "Sidebar"]]]
      ]
     ]]))
