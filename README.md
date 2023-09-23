# Kullanım

```console
hello@world:~$ docker-compose -f seleniumgridvideo.yml -up -d
```

localhost:4445 --> selenium-grid

# Selenium Grid Video Yapılandırması

Bu YAML dosyası, Chrome, Firefox ve Edge tarayıcılarıyla bir Selenium Grid kurmak için bir Docker Compose yapılandırma dosyasıdır. Yapılandırma, Selenium Hub servisi ve her tarayıcı için üç düğüm hizmeti içerir. Her düğüm hizmeti, Selenium etkinlik veri yolu ana bilgisayar, yayın bağlantı noktası, abone bağlantı noktası ve maksimum oturumlar için çevre değişkenleriyle yapılandırılmıştır. Chrome, Firefox ve Edge düğüm hizmetleri, paylaşılan bellek boyutu ve VNC ve hata ayıklama için açık bağlantı noktaları ile yapılandırılmıştır. Ayrıca, her tarayıcıda çalıştırılan testleri kaydetmek için üç video hizmeti vardır. Video hizmetleri, görüntüleme konteyner adı ve dosya adı için çevre değişkenleriyle yapılandırılmıştır.

## Hizmetler

### HubService

Selenium Hub servisi.

- Image: selenium/hub:latest
- Container name: seleniumHub
- Ports:
    - "4445:4444"
    - "4442:4442"
    - "4443:4443"

### ChromeService

Chrome tarayıcısı için düğüm hizmeti.

- Image: selenium/node-chrome:latest
- Shared memory size: 2gb
- Ports:
    - "5900"
    - "7900"
- Environment variables:
    - SE_EVENT_BUS_HOST=seleniumHub
    - SE_EVENT_BUS_PUBLISH_PORT=4442
    - SE_EVENT_BUS_SUBSCRIBE_PORT=4443
    - SE_NODE_MAX_SESSIONS=4
- Depends on:
    - HubService

### FirefoxService

Firefox tarayıcısı için düğüm hizmeti.

- Image: selenium/node-firefox:latest
- Shared memory size: 2gb
- Ports:
    - "5900"
    - "7900"
- Environment variables:
    - SE_EVENT_BUS_HOST=seleniumHub
    - SE_EVENT_BUS_PUBLISH_PORT=4442
    - SE_EVENT_BUS_SUBSCRIBE_PORT=4443
    - SE_NODE_MAX_SESSIONS=2
- Depends on:
    - HubService

### EdgeService

Edge tarayıcısı için düğüm hizmeti.

- Image: selenium/node-edge:latest
- Shared memory size: 2gb
- Ports:
    - "5900"
    - "7900"
- Environment variables:
    - SE_EVENT_BUS_HOST=seleniumHub
    - SE_EVENT_BUS_PUBLISH_PORT=4442
    - SE_EVENT_BUS_SUBSCRIBE_PORT=4443
    - SE_NODE_MAX_SESSIONS=2
- Depends on:
    - HubService

### chrome_video

Chrome tarayıcısı için video hizmeti.

- Image: selenium/video:ffmpeg-4.3.1-20230920
- Volumes:
    - ./TestRecordings:/videos
- Depends on:
    - ChromeService
- Environment variables:
    - DISPLAY_CONTAINER_NAME=ChromeService
    - FILE_NAME=chrome_video.mp4

### edge_video

Edge tarayıcısı için video hizmeti.

- Image: selenium/video:ffmpeg-4.3.1-20230920
- Volumes:
    - ./TestRecordings:/videos
- Depends on:
    - EdgeService
- Environment variables:
    - DISPLAY_CONTAINER_NAME=EdgeService
    - FILE_NAME=edge_video.mp4

### firefox_video

Firefox tarayıcısı için video hizmeti.

- Image: selenium/video:ffmpeg-4.3.1-20230920
- Volumes:
    - ./TestRecordings:/videos
- Depends on:
    - FirefoxService
- Environment variables:
    - DISPLAY_CONTAINER_NAME=FirefoxService
    - FILE_NAME=firefox_video.mp4

## Kaynaklar

- https://www.youtube.com/watch?v=NjQ5zZM7fpI
- https://www.youtube.com/watch?v=r1gdJ-QICmY

Not: Şifre "secret" olarak ayarlanmıştır.

# Note

Bu kod Trendyol UI testini içerir.
Bu test Page Object Model ile oluşturulmuştur.

Page Object Model hakkında daha fazla bilgi için lütfen şu yazımı okuyun:
https://medium.com/@semihsaydam/seleniumda-page-object-pattern-yapısı-d152c916505d


Be Happy :)
