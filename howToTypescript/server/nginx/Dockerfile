FROM nginx
ADD nginx.conf /etc/nginx/nginx.conf
ADD default.conf /etc/nginx/conf.d/default.conf
ADD ./keys/server.crt /etc/nginx/server.crt
ADD ./keys/server.key /etc/nginx/server.key

RUN mkdir /var/logs/
RUN chmod 755 -R /var
RUN chmod 400 /etc/nginx/server.key
