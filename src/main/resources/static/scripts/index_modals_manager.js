const buttons = document.querySelectorAll(".button");
const modalOverlay =  document.querySelector(".modal-overlay");
const modals = document.querySelectorAll(".modal")

buttons.forEach((e1) => {
    e1.addEventListener("click", (e) => {
        let path= e.currentTarget.getAttribute("data-path");
        modals.forEach((e1) => {
            e1.classList.remove("modals--visible");
        })
        document.getElementById(path).classList.add(path)
        document.getElementById(path).classList.add("modals--visible");
        modalOverlay.classList.add("modal-overlay--visible");
    })
})

modalOverlay.addEventListener("click", (e) => {
    if (e.target === modalOverlay) {
        modalOverlay.classList.remove("modal-overlay--visible");
        modals.forEach((e1) => {
            e1.classList.remove("modals--visible");
        })
    }
})