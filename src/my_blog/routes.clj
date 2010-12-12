(ns my-blog.routes
  (:use [compojure.core])
  (:require [compojure.route :as route]
            [my-blog.post :as post]
            [clj-json.core :as json]))

(defroutes index
  (GET "/" [] "<h1>My Blog!</h1>")
  (route/files "/" {:root "public"})
  (route/not-found "Page not found"))

(defn json-response [data & [status]]
  {:status (or status 200)
   :headers {"Content-Type" "application/json"}
   :body (json/generate-string data)})

(defroutes handler
  (GET "/posts" [] (json-response (post/find-all)))
  (GET "/posts/:id" [id] (json-response (post/find id)))
  (POST "/posts" {params :params} (json-response (post/create)))

  (route/files "/" {:root "public"})
  (route/not-found "Page not found"))

(def my-blog
     handler)
