/*
 Copyright (c) 2003-2017, CKSource - Frederico Knabben. All rights reserved.
 For licensing, see LICENSE.md or http://ckeditor.com/license
*/
(function() {
    var v = function(d, l) {
        function v() {
            var a = arguments,
            b = this.getContentElement("advanced", "txtdlgGenStyle");
            b && b.commit.apply(b, a);
            this.foreach(function(b) {
                b.commit && "txtdlgGenStyle" != b.id && b.commit.apply(b, a)
            })
        }
        function k(a) {
            if (!w) {
                w = 1;
                var b = this.getDialog(),
                c = b.imageElement;
                if (c) {
                    this.commit(1, c);
                    a = [].concat(a);
                    for (var d = a.length,
                    f, g = 0; g < d; g++)(f = b.getContentElement.apply(b, a[g].split(":"))) && f.setup(1, c)
                }
                w = 0
            }
        }
        var m = /^\s*(\d+)((px)|\%)?\s*$/i,
        z = /(^\s*(\d+)((px)|\%)?\s*$)|^$/i,
        r = /^\d+px$/,
        A = function() {
            var a = this.getValue(),
            b = this.getDialog(),
            c = a.match(m);
            c && ("%" == c[2] && n(b, !1), a = c[1]);
            b.lockRatio && (c = b.originalElement, "true" == c.getCustomData("isReady") && ("txtHeight" == this.id ? (a && "0" != a && (a = Math.round(a / c.$.height * c.$.width)), isNaN(a) || b.setValueOf("info", "txtWidth", a)) : (a && "0" != a && (a = Math.round(a / c.$.width * c.$.height)), isNaN(a) || b.setValueOf("info", "txtHeight", a))));
            e(b)
        },
        e = function(a) {
            if (!a.originalElement || !a.preview) return 1;
            a.commitContent(4, a.preview);
            return 0
        },
        w,
        n = function(a, b) {
            if (!a.getContentElement("info", "ratioLock")) return null;
            var c = a.originalElement;
            if (!c) return null;
            if ("check" == b) {
                if (!a.userlockRatio && "true" == c.getCustomData("isReady")) {
                    var d = a.getValueOf("info", "txtWidth"),
                    f = a.getValueOf("info", "txtHeight"),
                    c = 1E3 * c.$.width / c.$.height,
                    g = 1E3 * d / f;
                    a.lockRatio = !1;
                    d || f ? isNaN(c) || isNaN(g) || Math.round(c) != Math.round(g) || (a.lockRatio = !0) : a.lockRatio = !0
                }
            } else void 0 !== b ? a.lockRatio = b: (a.userlockRatio = 1, a.lockRatio = !a.lockRatio);
            d = CKEDITOR.document.getById(t);
            a.lockRatio ? d.removeClass("cke_btn_unlocked") : d.addClass("cke_btn_unlocked");
            d.setAttribute("aria-checked", a.lockRatio);
            CKEDITOR.env.hc && d.getChild(0).setHtml(a.lockRatio ? CKEDITOR.env.ie ? "■": "▣": CKEDITOR.env.ie ? "□": "▢");
            return a.lockRatio
        },
        B = function(a, b) {
            var c = a.originalElement;
            if ("true" == c.getCustomData("isReady")) {
                var d = a.getContentElement("info", "txtWidth"),
                f = a.getContentElement("info", "txtHeight"),
                g;
                b ? c = g = 0 : (g = c.$.width, c = c.$.height);
                d && d.setValue(g);
                f && f.setValue(c)
            }
            e(a)
        },
        C = function(a, b) {
            function c(a, b) {
                var c = a.match(m);
                return c ? ("%" == c[2] && (c[1] += "%", n(d, !1)), c[1]) : b
            }
            if (1 == a) {
                var d = this.getDialog(),
                f = "",
                g = "txtWidth" == this.id ? "width": "height",
                e = b.getAttribute(g);
                e && (f = c(e, f));
                f = c(b.getStyle(g), f);
                this.setValue(f)
            }
        },
        x,
        u = function() {
            var a = this.originalElement,
            b = CKEDITOR.document.getById(p);
            a.setCustomData("isReady", "true");
            a.removeListener("load", u);
            a.removeListener("error", h);
            a.removeListener("abort", h);
            b && b.setStyle("display", "none");
            this.dontResetSize || B(this, !1 === d.config.image_prefillDimensions);
            this.firstLoad && CKEDITOR.tools.setTimeout(function() {
                n(this, "check")
            },
            0, this);
            this.dontResetSize = this.firstLoad = !1;
            e(this)
        },
        h = function() {
            var a = this.originalElement,
            b = CKEDITOR.document.getById(p);
            a.removeListener("load", u);
            a.removeListener("error", h);
            a.removeListener("abort", h);
            a = CKEDITOR.getUrl(CKEDITOR.plugins.get("image").path + "images/noimage.png");
            this.preview && this.preview.setAttribute("src", a);
            b && b.setStyle("display", "none");
            n(this, !1)
        },
        q = function(a) {
            return CKEDITOR.tools.getNextId() + "_" + a
        },
        t = q("btnLockSizes"),
        y = q("btnResetSize"),
        p = q("ImagePreviewLoader"),
        E = q("previewLink"),
        D = q("previewImage");
        return {
            title: d.lang.image["image" == l ? "title": "titleButton"],
            minWidth: "moono-lisa" == (CKEDITOR.skinName || d.config.skin) ? 500 : 420,
            minHeight: 360,
            onShow: function() {
                this.linkEditMode = this.imageEditMode = this.linkElement = this.imageElement = !1;
                this.lockRatio = !0;
                this.userlockRatio = 0;
                this.dontResetSize = !1;
                this.firstLoad = !0;
                this.addLink = !1;
                var a = this.getParentEditor(),
                b = a.getSelection(),
                c = (b = b && b.getSelectedElement()) && a.elementPath(b).contains("a", 1),
                d = CKEDITOR.document.getById(p);
                d && d.setStyle("display", "none");
                x = new CKEDITOR.dom.element("img", a.document);
                this.preview = CKEDITOR.document.getById(D);
                this.originalElement = a.document.createElement("img");
                this.originalElement.setAttribute("alt", "");
                this.originalElement.setCustomData("isReady", "false");
                c && (this.linkElement = c, this.addLink = this.linkEditMode = !0, a = c.getChildren(), 1 == a.count() && (d = a.getItem(0), d.type == CKEDITOR.NODE_ELEMENT && (d.is("img") || d.is("input")) && (this.imageElement = a.getItem(0), this.imageElement.is("img") ? this.imageEditMode = "img": this.imageElement.is("input") && (this.imageEditMode = "input"))), "image" == l && this.setupContent(2, c));
                if (this.customImageElement) this.imageEditMode = "img",
                this.imageElement = this.customImageElement,
                delete this.customImageElement;
                else if (b && "img" == b.getName() && !b.data("cke-realelement") || b && "input" == b.getName() && "image" == b.getAttribute("type")) this.imageEditMode = b.getName(),
                this.imageElement = b;
                this.imageEditMode && (this.cleanImageElement = this.imageElement, this.imageElement = this.cleanImageElement.clone(!0, !0), this.setupContent(1, this.imageElement));
                n(this, !0);
                CKEDITOR.tools.trim(this.getValueOf("info", "txtUrl")) || (this.preview.removeAttribute("src"), this.preview.setStyle("display", "none"))
            },
            onOk: function() {
                if (this.imageEditMode) {
                    var a = this.imageEditMode;
                    "image" == l && "input" == a && confirm(d.lang.image.button2Img) ? (this.imageElement = d.document.createElement("img"), this.imageElement.setAttribute("alt", ""), d.insertElement(this.imageElement)) : "image" != l && "img" == a && confirm(d.lang.image.img2Button) ? (this.imageElement = d.document.createElement("input"), this.imageElement.setAttributes({
                        type: "image",
                        alt: ""
                    }), d.insertElement(this.imageElement)) : (this.imageElement = this.cleanImageElement, delete this.cleanImageElement)
                } else "image" == l ? this.imageElement = d.document.createElement("img") : (this.imageElement = d.document.createElement("input"), this.imageElement.setAttribute("type", "image")),
                this.imageElement.setAttribute("alt", "");
                this.linkEditMode || (this.linkElement = d.document.createElement("a"));
                this.commitContent(1, this.imageElement);
                this.commitContent(2, this.linkElement);
                this.imageElement.getAttribute("style") || this.imageElement.removeAttribute("style");
                this.imageEditMode ? !this.linkEditMode && this.addLink ? (d.insertElement(this.linkElement), this.imageElement.appendTo(this.linkElement)) : this.linkEditMode && !this.addLink && (d.getSelection().selectElement(this.linkElement), d.insertElement(this.imageElement)) : this.addLink ? this.linkEditMode ? this.linkElement.equals(d.getSelection().getSelectedElement()) ? (this.linkElement.setHtml(""), this.linkElement.append(this.imageElement, !1)) : d.insertElement(this.imageElement) : (d.insertElement(this.linkElement), this.linkElement.append(this.imageElement, !1)) : d.insertElement(this.imageElement)
            },
            onLoad: function() {
                "image" != l && this.hidePage("Link");
                var a = this._.element.getDocument();
                this.getContentElement("info", "ratioLock") && (this.addFocusable(a.getById(y), 5), this.addFocusable(a.getById(t), 5));
                this.commitContent = v
            },
            onHide: function() {
                this.preview && this.commitContent(8, this.preview);
                this.originalElement && (this.originalElement.removeListener("load", u), this.originalElement.removeListener("error", h), this.originalElement.removeListener("abort", h), this.originalElement.remove(), this.originalElement = !1);
                delete this.imageElement
            },
            contents: [
            {
                id: "Upload",
                hidden: !0,
                filebrowser: "uploadButton",
                label: d.lang.image.upload,
                elements: [{
                    type: "file",
                    id: "upload",
                    label: d.lang.image.btnUpload,
                    style: "height:40px",
                    size: 38
                },
                {
                    type: "fileButton",
                    id: "uploadButton",
                    filebrowser: "info:txtUrl",
                    label: d.lang.image.btnUpload,
                    "for": ["Upload", "upload"]
                }]
            }]
        }
    };
    CKEDITOR.dialog.add("image",
    function(d) {
        return v(d, "image")
    });
    CKEDITOR.dialog.add("imagebutton",
    function(d) {
        return v(d, "imagebutton")
    })
})();