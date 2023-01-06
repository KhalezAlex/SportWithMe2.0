let dataPaths = ["profile", "log_reg", "admin", "new_event", "chat"];
const modalOverlay = document.querySelector(".modal-overlay");
// const modals = [document.getElementById("modal_profile"), document.getElementById("modal_log_reg"),
//     document.getElementById("modal_admin")];
const modals = [$("#modal_profile"), $("#modal_log_reg"), $("#modal_admin")];

buttonModalsListeners();

function hideModalsExceptTarget(path) {
    // modals.forEach((e1) => {
    //     if (e1 !== null)
    //         e1.classList.remove("modals--visible");
    // });
    // if (document.getElementById(path) != null) {
    //     document.getElementById(path).classList.add(path);
    //     document.getElementById(path).classList.add("modals--visible");
    // }
    // modalOverlay.classList.add("modal-overlay--visible");
    dataPaths.forEach((e) => {
        $("#modal_" + e).attr("class", "modal");
    })
    let modal = $("#" + path);
    if (modal !== null)
        modal.attr("class", path);
    modalOverlay.classList.add("modal-overlay--visible")
}


function buttonModalsListeners() {
    buttonLogRegEventListener();
    buttonAdminListener();
    buttonProfileListener();
}

function buttonLogRegEventListener() {
    let id = "button_" + dataPaths[0];
    if (document.getElementById(id) != null)
        document.getElementById(id).addEventListener("click", function () {
            chooseLogin();
            hideModalsExceptTarget("modal_" + dataPaths[0]);
        })
}

function buttonProfileListener() {
    let id = "button_" + dataPaths[1];
    if (document.getElementById(id) !== null)
        document.getElementById(id).addEventListener("click", function () {
            hideModalsExceptTarget("modal_" + dataPaths[1]);
        })
}

function buttonAdminListener() {
    let id = "button_" + dataPaths[2];
    document.getElementById(id).addEventListener("click", function () {
        hideModalsExceptTarget("modal_" + dataPaths[2]);
    })
}

modalOverlay.addEventListener("click", (e) => {
    if (e.target === modalOverlay) {
        modalOverlay.classList.remove("modal-overlay--visible");
        modals.forEach((e1) => {
            if (e1 != null)
                e1.attr("class", "modal");
        })
        hideInputs();
        showSpans();
        clickToUpdateProfileListener();
        onLoadRequest();
    }
})


// function buttonModalsListeners2() {
//     buttonIds.forEach((e1) => {
//         // console.log(e1 + " : " + document.getElementById(e1))
//         document.getElementById(e1).addEventListener("click", (e) => {
//             let path = e.currentTarget.getAttribute("data-path");
//             if (path === "modal_log_reg")
//                 chooseLogin();
//             modals.forEach((e1) => {
//                 e1.classList.remove("modals--visible");
//             })
//             document.getElementById(path).classList.add(path)
//             document.getElementById(path).classList.add("modals--visible");
//             modalOverlay.classList.add("modal-overlay--visible");
//         })
//     })
// }

// // const buttons = document.querySelectorAll(".button");
// const buttons = [$("#button_new_event"), $("#button_chat"), $("#button_admin_page"),
//                 $("#button_log_reg_form"), $("#button_profile")];
// // const buttons = ["button_new_event", "button_chat", "button_admin_page", "button_log_reg_form", "button_profile"]
// const modalOverlay = document.querySelector(".modal-overlay");
// const modals = document.querySelectorAll(".modal")
//
// buttons.forEach((e1) => {
//     e1.on("click", (e) => {
//         let path = e.currentTarget.getAttribute("data-path");
//         if (path === "modal_log_reg")
//             chooseLogin();
//         modals.forEach((e1) => {
//             e1.classList.remove("modals--visible");
//         })
//         document.getElementById(path).classList.add(path)
//         document.getElementById(path).classList.add("modals--visible");
//         modalOverlay.classList.add("modal-overlay--visible");
//     })
// })
//
// modalOverlay.addEventListener("click", (e) => {
//     if (e.target === modalOverlay) {
//         modalOverlay.classList.remove("modal-overlay--visible");
//         modals.forEach((e1) => {
//             e1.classList.remove("modals--visible");
//         })
//     }
// })

// let buttonIds = ["button_new_event", "button_chat", "button_admin_page", "button_log_reg_form", "button_profile"]