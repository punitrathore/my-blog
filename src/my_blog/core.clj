(ns my-blog.core
  (:use [compojure.core]
        [ring.adapter.jetty])
  (:require [compojure.route :as route]))

(defroutes index
  (GET "/" [] "<h1>My Blog!</h1>")
  (route/files "/" {:root "public"})
  (route/not-found "Page not found"))

 (future (run-jetty index {:port 8080}))


