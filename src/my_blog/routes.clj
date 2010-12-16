(ns my-blog.routes
  (:use [compojure.core])
  (:require [compojure.route :as route]
            [my-blog.post :as post]
            [clj-json.core :as json]
            [my-blog.html :as html]
            [my-blog.layout :as layout]
            [my-blog.views :as views]))

(defn json-response [data & [status]]
  {:status (or status 200)
   :headers {"Content-Type" "application/json"}
   :body (json/generate-string data)})

(defroutes post-routes
  (GET "/posts" [] (views/index-page))
  (GET "/posts/new" [] (views/new-post-page))
  (GET "/posts/:id" [id] (layout/wrap-with-layout (html/render-post (post/find-post id))))
  (POST "/posts" {params :params} (views/create-new-post params))
  (route/files "/" {:root "public"})
  (route/not-found "Page not found"))
