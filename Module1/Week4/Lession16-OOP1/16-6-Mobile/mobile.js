const mobileNames = ["Nokia", "iPhone"]
const receiveSentMsg = [[]]

class Mobile {
    constructor(name) {
        this.name = name
        this.pin = 50;
        this.msg = "";
        this.inbox = "";
        this.sentTo = ""
        this.status = "off";
    }

    statusCheck() {
        let div = document.getElementById(`${this.name}`)
        if (this.status === "off") {
            div.innerHTML = `Điện thoại đang tắt<br>`
        } else {
            div.innerHTML = `Điện thoại đang bật<br>`
        }
    }

    turnOn() {
        this.status = "on"
        this.statusCheck()
        this.pin -= 1
    }

    turnOff() {
        this.status = "off"
        this.statusCheck()
        this.pin -= 1
    }

    pinCheck() {
        if (this.status === "on") {
            let div = document.getElementById(`${this.name}`)
            div.innerHTML += `Trạng thái pin: ${this.pin}% <br>`
        }
    }

    charge(how) {
        for (let i = 0; i < how; i++) {
            this.pin += 1
        }
        this.pinCheck()
    }

    createMsg(string) {
        let div = document.getElementById(`${this.name}`)
        if (this.status === "on") {
            this.msg = string
            div.innerHTML += `Tin nhắn chưa gửi: "${this.msg}"<br>`
            this.pin -= 1
        }
    }

    sendMsg(which) {
        if (this.status === "on") {
            let div = document.getElementById(`${this.name}`)
            for (let i = 0; i < mobileNames.length; i++) {
                if (which === mobileNames[i] && mobileNames[i] !== this.name) {
                    div.innerHTML += `Đã gửi tin nhắn!<br>`
                    receiveSentMsg[mobileNames.indexOf(which)] = [`${which}`, `${this.name}`, `${this.msg}`]
                    this.sentTo = which
                }
            }
            this.pin -= 1
        }
    }

    checkInbox() {
        if (this.status === "on") {
            let div = document.getElementById(`${this.name}`)
            for (let i = 0; i < receiveSentMsg.length; i++) {
                if (this.name === receiveSentMsg[i][0]) {
                    this.inbox = receiveSentMsg[i][2]
                    div.innerHTML += `Hộp thư đến: "${this.inbox}" <br>
                                           Người gửi: ${receiveSentMsg[i][1]}<br>`
                }
            }
            this.pin -= 1
        }
    }

    checkMsgSent() {
        if (this.status === "on") {
            let div = document.getElementById(`${this.name}`)
            div.innerHTML += `Tin nhắn đã gửi gần nhất: "${this.msg}"<br>
                                    Người nhận: ${this.sentTo}<br>`
            this.pin -= 1
        }
    }

}

const nokia = new Mobile("Nokia")
const iphone = new Mobile("iPhone")
nokia.turnOn()
iphone.turnOn()
nokia.pinCheck()
iphone.pinCheck()
nokia.createMsg("Hello")
nokia.sendMsg("iPhone")
iphone.checkInbox()
nokia.checkMsgSent()
nokia.pinCheck()
iphone.pinCheck()