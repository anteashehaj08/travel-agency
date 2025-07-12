document.getElementById("contactForm").addEventListener("submit", function (e) {
    e.preventDefault();
    const formMsg = document.getElementById("formMsg");
    formMsg.textContent = "Thanks for your message! We’ll get back to you soon.";
    formMsg.style.color = "green";
    this.reset();
});