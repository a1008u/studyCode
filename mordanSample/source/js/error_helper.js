ErrorHelper = (function() {
    return {
        containsErrors: function (response) {if (!response || !response.responseText) return false
            let errorValue = response.responseText
            if (String(errorValue.failure) == "true" || Boolean(errorValue.failure)) return true
            return false
        },
        trace: function (msg) {let traceMessage = msg
            if (msg.responseText) traceMessage = msg.responseText.errorMessage
            console.log("[" + new Date().toLocaleDateString() + "] " + traceMessage);
        }
    }
})();


let failureMessage = {responseText : {"failure" :true, "errorMessage" : "Message From failureMessage"}}
let failureMessageString = {responseText : {"failure" : "true", "errorMessage" : "Message from failureMessageString"}}
let successMessage = {responseText : {"failure" : false}}

if (ErrorHelper.containsErrors(failureMessage)) ErrorHelper.trace(failureMessage);
if (ErrorHelper.containsErrors(failureMessageString)) ErrorHelper.trace(failureMessageString);
if (!ErrorHelper.containsErrors(successMessage)) ErrorHelper.trace("success");

