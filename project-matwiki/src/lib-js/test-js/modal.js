(function() {
    "use strict";


    var DefaultOption = function() {
        this.shadow_opacity = 0.6; //default 0.5 최소 0 , 최대 1
        this.startY = "150";
        this.suffix = "%";
        this.endY = "60";
        this.openCallback = function() {};
        this.closeCallback = function() {};
        this.delay = 0.50;
        this.onClose = true;

        this.openOption = {
            display: "block",
            scaleX: 1,
            opacity: 1,
            ease: Power3.easeOut,
            onComplete: this.openCallback
        };

        this.closeOption = {
            display: "none",
            scaleX: 0.7,
            opacity: 0,
            ease: Power3.easeOut,
            onComplete: this.closeCallback
        };
    };

    DefaultOption.prototype.setOption = function(newOption) {
        var myOption = this;
        for (var prop in newOption) {
            if (myOption.hasOwnProperty(prop)) {
                myOption[prop] = newOption[prop];
            }
        }
        return myOption;
    };


    function Modal(modalElement, option) {
        if (this instanceof Modal) {
            this.Element = document.getElementById(modalElement) || modalElement;
            if (this.Element === null) {
                return false;
            }
            this.Init(option);
        } else {
            return new Modal(modalElement, option);
        }
    }


    Modal.prototype.Init = function(newOption) {
        var self = this;
        var ele = this.Element;
        this.Option = new DefaultOption();
        this.Option = this.Option.setOption(newOption || {});
        // console.log(this.Option);
        var cssObject = {
          "-moz-transform" : "translateY(" + (this.Option.startY + this.Option.suffix) + ")",
          "-webkit-transform" : "translateY(" + (this.Option.startY + this.Option.suffix) + ")",
          "-o-transform" : "translateY(" + (this.Option.startY + this.Option.suffix) + ")",
          "-ms-transform" : "translateY(" + (this.Option.startY + this.Option.suffix) + ")",
          "transform" : "translateY(" + (this.Option.startY + this.Option.suffix) + ")",
        };
        ele.setAttribute("style", twCom.fn.convertStyle(cssObject));
        this.openbtnSetting();
        this.closebtnSetting();
    };




    Modal.prototype.openbtnSetting = function() {
        var id = this.Element.id;
        var buttons = document.querySelectorAll("[data-modal=" + id + "]"); // querySelectorAll의 반환값은 Array임 무조건
        if (buttons.length > 0) {
            for (var index = 0; index < buttons.length; index++) {
                buttons[index].addEventListener("click", this.openModal.bind(this));
            }
        } else {
            console.warn('모달 컴포넌트 open button element가 존재하지않습니다.');
        }
    };

    Modal.prototype.closebtnSetting = function() {
        var buttons = this.Element.getElementsByClassName("close-modal"); // getElementsByClassName의 반환값은 Array임 무조건
        if (buttons.length > 0) {
            for (var index = 0; index < buttons.length; index++) {
                buttons[index].setAttribute("data-modal", this.Element.id);
                buttons[index].addEventListener("click", this.closeModal.bind(this));
            }
        }
    };


    Modal.prototype.openModal = function(e) {
        var element = e && e.target ? e.target : null;
        var target = element ? element.getAttribute('id') : this.Element.getAttribute('id');

        if (target) {
            var modalElement = this.Element;
            var shadowElement = this.createShadow(target);
            var modalOption = this.Option;
            modalOption.openOption.y = modalOption.endY + modalOption.suffix;
            modalOption.openOption.onComplete = modalOption.openCallback;
            TweenLite.to(shadowElement, modalOption.delay, {
                opacity: modalOption.shadow_opacity
            });
            TweenLite.to(modalElement, modalOption.delay, modalOption.openOption);
            document.body.style.overflow = "hidden";
        } else {
            throw new Error("Error Modal Open Error");
        }
    };

    Modal.prototype.closeModal = function(e) {
        var element = e && e.target ? e.target : null;
        var target = element ? element.getAttribute('id') : this.Element.getAttribute('id');

        if (target) {
            var modalElement = this.Element;
            var shadowElement = this.shadowEle;
            var modalOption = this.Option;
            modalOption.closeOption.y = modalOption.startY + modalOption.suffix;
            modalOption.closeOption.onComplete = modalOption.closeCallback;

            TweenLite.to(shadowElement, modalOption.delay, {
                opacity: 0,
                onComplete: function() {
                    if (shadowElement) {
                        shadowElement.parentElement.removeChild(shadowElement);
                    }
                }
            });
            TweenLite.to(modalElement, modalOption.delay, modalOption.closeOption);
            document.body.style.overflow = "";
        } else {
            throw new Error("Error Modal Close Error");
        }
    };



    Modal.prototype.setOption = function(Option) {
        if (typeof Option === "object") {
            this.Option = this.Option.setOption(Option);
        } else {
            throw new Error("setOption의 인자는 Object");
        }
    };


    Modal.prototype.createShadow = function(id) {
        var Shadowele = document.createElement("div");
        var Option = this.Option;
        Shadowele.id = "modal-shadow";
        Shadowele.setAttribute("data-modal", id);
        if (Option.onClose) {
            Shadowele.addEventListener("click", this.closeModal.bind(this));
        }
        //옵션에서 준 Shadow_onclick_close  값에 따라 true면 그림자영역 클릭시 모달 close / false 이면 그림자영역 클릭이벤트를 설정하지않음.
        this.shadowEle = Shadowele;
        return document.body.appendChild(Shadowele);
    };

    window.twCom.Modal = {
        init: Modal
    };
})();
