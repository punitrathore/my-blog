(ns my-blog.config)

(def *MY-BLOG-DB* {
     :development {
            :classname "com.mysql.jdbc.Driver"
            :subprotocol "mysql"
            :user "root"
            :password ""
            :subname (str "//localhost/my_blog_development") }
     :test {
            :classname "com.mysql.jdbc.Driver"
            :subprotocol "mysql"
            :user "runa_user"
            :password "runa_pass"
            :subname (str "//localhost/my_blog_test") }
     :load {
            :classname "com.mysql.jdbc.Driver"
            :subprotocol "mysql"
            :user "root"
            :password ""
            :subname (str "//localhost/my_blog_load") }
     :staging {
            :classname "com.mysql.jdbc.Driver"
            :subprotocol "mysql"
      :user "root"
            :password ""
            :subname (str "//localhost/my_blog_development") }})
