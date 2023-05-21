$(function() {
	var slides = $('.slides'),
	images = slides.find('img');

	images.each(function(i) {
		$(this).attr('data-id', i + 1);
	})

	var typed = new Typed('.typed-words', {
		strings: [" 서울."," 부산."," 제주도.", " 경상도.", " 전라도."],
		typeSpeed: 80,
		backSpeed: 80,
		backDelay: 4000,
		startDelay: 1000,
		loop: true,
		showCursor: true,
		preStringTyped: (arrayPos, self) => {
			arrayPos++;
			$('.slides img').removeClass('active');
			$('.slides img[data-id="'+arrayPos+'"]').addClass('active');
		}
	});
})