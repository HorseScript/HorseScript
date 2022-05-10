/*
 * Copyright (c) 2022, HorseScript
 * All rights reserved.
 */

package Interpreter.resources;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class HorseError extends Exception {

    @java.io.Serial static final long serialVersionUID = -7034897190745766939L;


    /** Constructs a new runtime exception with {@code null} as its
     * detail message.  The cause is not initialized, and may subsequently be
     * initialized by a call to {@link #initCause}.
     */
    public HorseError () {
        super();
    }


    /** Constructs a new runtime exception with the specified detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     *
     * @param   message   the detail message. The detail message is saved for
     *          later retrieval by the {@link #getMessage()} method.
     */
    public HorseError (String message) {
        super(message);
    }


    /**
     * Constructs a new runtime exception with the specified detail message and
     * cause.  <p>Note that the detail message associated with
     * {@code cause} is <i>not</i> automatically incorporated in
     * this runtime exception's detail message.
     *
     * @param  message the detail message (which is saved for later retrieval
     *         by the {@link #getMessage()} method).
     * @param  cause the cause (which is saved for later retrieval by the
     *         {@link #getCause()} method).  (A {@code null} value is
     *         permitted, and indicates that the cause is nonexistent or
     *         unknown.)
     * \
     */
    public HorseError (String message, Throwable cause) {
        super(message, cause);
    }


    /**
     * Constructs a new runtime exception with the specified detail
     * message, cause, suppression enabled or disabled, and writable
     * stack trace enabled or disabled.
     *
     * @param  message the detail message.
     * @param cause the cause.  (A {@code null} value is permitted,
     * and indicates that the cause is nonexistent or unknown.)
     * @param enableSuppression whether or not suppression is enabled
     *                          or disabled
     * @param writableStackTrace whether or not the stack trace should
     *                           be writable
     *
     *
     */
    protected HorseError (String message, Throwable cause,
                               boolean enableSuppression,
                               boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public static void badLine (@NotNull String line, @Nullable String customMessage) {


        if (customMessage == null) {
            String message = "HorseScript: " + "\u001B[36m" + "{\"error\": \"Unknown command\", \"command\": \"" + line + "\"}"; // Cyan
            System.out.println("\u001B[31m" + "[HorseError] " + message); // Red


        } else {
            String message = "HorseScript: " + "\u001B[36m" + "{\"error\": \"Unknown command\", \"command\": \"" + line + "\", \"message\": \"" + customMessage + "\"}"; // Cyan
            System.out.println("\u001B[31m" + "[HorseError] " + message); // Red



        }



    }

}
