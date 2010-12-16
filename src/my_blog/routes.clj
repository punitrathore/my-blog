(ns my-blog.routes
  (:use [compojure.core])
  (:require [compojure.route :as route]
            [my-blog.post :as post]
            [clj-json.core :as json]
            [my-blog.html :as html]
            [my-blog.layout :as layout]))

(defn json-response [data & [status]]
  {:status (or status 200)
   :headers {"Content-Type" "application/json"}
   :body (json/generate-string data)})

(defroutes post-routes
  (GET "/posts" [] (layout/wrap-with-layout (map html/render-post (post/find-all-posts))))
  (GET "/posts/:id" [id] (layout/wrap-with-layout (html/render-post (post/find-post id))))

  (route/files "/" {:root "public"})
  (route/not-found "Page not found"))
