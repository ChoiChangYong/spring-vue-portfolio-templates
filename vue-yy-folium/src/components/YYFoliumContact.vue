<template>
    <!-- Contact Section START -->
    <div class="contact" id="contact">
        <!-- Section Title START -->
        <div class="container section-title">
            <div class="container pr-title">
                <h2><span>Contact</span> Me</h2>

                <p>A Few Words About Contact Me</p>
            </div>
        </div>
        <!-- Section Title END -->

        <div class="wrap-contact-form">
            <form class="contact-form">
                <h2>Send Me A Message</h2>

                <label class="field-label" for="first-name">Enter Your Name *</label>
                <div class="wrap-field wrap-field-left field-validate" data-validate="Enter First Name">
                    <input id="first-name" class="input-field" type="text" name="first-name" placeholder="First Name">
                    <span class="field-animate"></span>
                </div>
                <div class="wrap-field wrap-field-right field-validate" data-validate="Enter Last Name">
                    <input id="last-name" class="input-field" type="text" name="last-name" placeholder="Last Name">
                    <span class="field-animate"></span>
                </div>

                <label class="field-label" for="email">Enter Your Email *</label>
                <div class="wrap-field field-validate" data-validate="Enter Valid Email">
                    <input id="email" class="input-field" type="text" name="email" placeholder="Eg. your-name@example.com">
                    <span class="field-animate"></span>
                </div>

                <label class="field-label" for="phone">Enter Your Phone Number</label>
                <div class="wrap-field">
                    <input id="phone" class="input-field" type="text" name="phone" placeholder="Eg. +1 234 567890">
                    <span class="field-animate"></span>
                </div>

                <label class="field-label" for="message">Message *</label>
                <div class="wrap-field field-validate" data-validate="Enter Your Message">
                    <textarea id="message" class="input-field" name="message" placeholder="Write Me a Message"></textarea>
                    <span class="field-animate"></span>
                </div>

                <div class="wrap-button">
                    <button class="contact-button">Send Message</button>
                </div>

                <div id="response-message" class="alert" role="alert"></div>
            </form>

            <div class="contact-info">
                <div class="contact-item">
                    <div class="contact-icon">
                        <i class="fas fa-map-marker-alt"></i>
                    </div>

                    <div class="contact-details">
                        <span class="contact-label">Address</span>

                        <span class="contact-detail">4384, Seeley Way Wellsville, NY 14895 US</span>
                    </div>
                </div>

                <div class="contact-item">
                    <div class="contact-icon">
                        <i class="fas fa-phone"></i>
                    </div>

                    <div class="contact-details">
                        <span class="contact-label">Lets Talk</span>

                        <span class="contact-detail">+1 234 567890</span>
                    </div>
                </div>

                <div class="contact-item">
                    <div class="contact-icon">
                        <i class="fas fa-envelope"></i>
                    </div>

                    <div class="contact-details">
                        <span class="contact-label">General Support</span>

                        <span class="contact-detail">
                                <a href="mailto:jonathan@example.com">jonathan@example.com</a>
                            </span>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Contact Section END -->
</template>

<script>
import $ from 'jquery'

export default {
    mounted() {
        // Contact Form Validation and Submission
        var contactForm = $('.contact-form');
        contactForm.on('submit', function(event) {
            submitContact(contactForm);

            event.preventDefault();
        });
        $('.contact-form .input-field').on('focus', function() {
            hideValidate(this);
        });

        function submitContact(contactForm) {
            'use strict';

            var check = true;

            var firstNameField = $('#first-name');
            var lastNameField = $('#last-name');
            var emailField = $('#email');
            var messageField = $('#message');

            if ($.trim(firstNameField.val()) == '') {
                showValidate(firstNameField);

                check = false;
            } else {
                hideValidate(firstNameField);
            }

            if ($.trim(lastNameField.val()) == '') {
                showValidate(lastNameField);

                check = false;
            } else {
                hideValidate(lastNameField);
            }

            if ($.trim(emailField.val()) == '') {
                showValidate(emailField);

                check = false;
            } else if ($.trim(emailField.val()).match(/^([a-zA-Z0-9_\-\\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\\-]+\.)+))([a-zA-Z]{1,5}|[0-9]{1,3})(\]?)$/) == null) {
                showValidate(emailField);

                check = false;
            } else {
                hideValidate(emailField);
            }

            if ($.trim(messageField.val()) == '') {
                showValidate(messageField);

                check = false;
            } else {
                hideValidate(messageField);
            }

            if (check) {
                var responseDisplay = $('#response-message');
                responseDisplay.removeClass('alert-success').removeClass('alert-danger').addClass('alert-primary').html('Please Wait...');

                $.ajax({
                    type: 'POST',
                    url: 'contact.php',
                    data: contactForm.serialize(),
                    success: function(response) {
                        var output = $.parseJSON(response);

                        if (output.Type == 'Success') {
                            responseDisplay.removeClass('alert-danger').addClass('alert-success').html(output.Messsage);
                        } else if (output.Type == 'Error') {
                            responseDisplay.removeClass('alert-success').addClass('alert-danger').html(output.Messsage);
                        }
                    }
                });
            }
        }

        // Show Contact Form Validaton Message
        function showValidate(input) {
            'use strict';

            var thisAlert = $(input).parent();

            $(thisAlert).addClass('validate-alert');
        }

        // Hide Contact Form Validaton Message
        function hideValidate(input) {
            'use strict';

            var thisAlert = $(input).parent();

            $(thisAlert).removeClass('validate-alert');
        }

    },
}
</script>

<style>

</style>