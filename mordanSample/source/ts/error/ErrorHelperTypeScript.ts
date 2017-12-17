
window.onload = () => {
    let failureMessage = {responseText : {"failure" : "true"
                                            , "errorMessage" : "Error Message from Typescript"}}

    // ErrorHelperは、jsのvariableのためd.tsでdeclare
    if (ErrorHelper.containsErrors(failureMessage)) ErrorHelper.trace(failureMessage)
}



/* --------------------------------------------------
[2017/12/11] Message From failureMessage
[2017/12/11] Message from failureMessageString
[2017/12/11] success
[2017/12/11] Error Message from Typescript
-------------------------------------------------- */




