var stompClient;
    $(document).ready(function() {
        var socket = new SockJS('/live-tweet-stream');
        stompClient = Stomp.over(socket);

		stompClient.connect({}, function(frame) {
		stompClient.subscribe('/topic/tweets', function(tweets) {
		    console.log(tweets.body);
            const tweet = JSON.parse(tweets.body);
            const tweetData = {
            id: tweet.data.id,
            text: tweet.data.text
        }
        const tweetEl = document.createElement('div')
        tweetEl.className = 'card my-4'
        tweetEl.innerHTML = `
            <div class="card-body">
                <h5 class="card-title">${tweetData.text}</h5>
            </div>
        `

        tweetStream.appendChild(tweetEl)

		    });
		});
    });

    function streamTweets() {
    const request = new XMLHttpRequest();
    if ($('#tweetSearch').val() == '') {
        return false;
    }
    var host = location.hostname;
    var url = 'http://' + host + ':8082/streamTweets?ruleFilter=' + $('#tweetSearch').val();
    request.open("GET", url);
    request.send();
    }