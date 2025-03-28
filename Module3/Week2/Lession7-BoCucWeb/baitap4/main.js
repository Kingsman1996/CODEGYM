document.addEventListener("DOMContentLoaded", function () {
    const videoList = document.querySelectorAll("#video-list li");
    const videoContainer = document.querySelector("#video-container");

    videoList.forEach(item => {
        item.addEventListener("click", function () {
            let videoUrl = this.getAttribute("data-video");

            if (videoUrl.includes("youtube.com")) {
                videoContainer.innerHTML = `
                    <iframe width="100%" height="400" src="${videoUrl.replace('watch?v=', 'embed/')}"> 
                    </iframe>`;
            } else {
                videoContainer.innerHTML = `
                    <video id="video-player" controls autoplay>
                        <source src="${videoUrl}" type="video/mp4">
                        Trình duyệt của bạn không hỗ trợ video.
                    </video>`;
            }
        });
    });
});
