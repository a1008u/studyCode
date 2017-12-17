class GlobalLogger {
    static logGlobalsToConsole() {
        for(let email of CONTACT_EMAIL_ARRAY) {
            console.log(`found contact : ${email}`)
        }
    }
}

class ContactLogger {
    static logContactData() {
        for (let contact of CONTACT_DATA) {
            console.log(`DisplayText: ${contact.DisplayText}, Email : ${contact.Email}`)
        }
    }
}

window.onload = () => {
    GlobalLogger.logGlobalsToConsole()
    ContactLogger.logContactData()
}

 /* --------------------------------------------
main.ts:6 found contact : help1@site.com
main.ts:6 found contact : contactus2@site.com
main.ts:6 found contact : webmaster3@site.com
main.ts:14 DisplayText: Help, Email : help11@site.com
main.ts:14 DisplayText: Help, Email : contactus22@site.com
main.ts:14 DisplayText: Help, Email : webmaster33@site.com
 -------------------------------------------- */


