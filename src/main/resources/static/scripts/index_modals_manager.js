// const buttons = document.querySelectorAll(".button");
const buttons = [$("#button_new_event"), $("#button_chat"), $("#button_admin_page"),
    $("#button_log_reg_form"), $("#button_profile")]
const modalOverlay =  document.querySelector(".modal-overlay");
const modals = document.querySelectorAll(".modal")

buttons.forEach((e1) => {
    e1.on("click", (e) => {
        let path= e.currentTarget.getAttribute("data-path");
        console.log(path)
        if (path === "modal_log_reg")
            flushRegistrationInputs();
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