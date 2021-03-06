package com.xt.kimi.uikit

import com.xt.endo.CGRect
import com.xt.endo.EDOCallback
import com.xt.endo.EDOJavaHelper
import com.xt.kimi.KIMIPackage

class UIProgressView: UIView() {

    var progress: Double = 0.0
        set(value) {
            field = value
            EDOJavaHelper.valueChanged(this, "progress")
            this.layoutIfNeeded()
        }

    fun setProgress(value: Double, animated: Boolean) {
        this.progress = value
        if (animated) {
            UIAnimator.shared.curve(0.30, EDOCallback.createWithBlock {
                this.layoutIfNeeded()
            }, null)
        }
        else {
            this.layoutIfNeeded()
        }
    }

    var progressTintColor: UIColor? = null
        set(value) {
            field = value
            EDOJavaHelper.valueChanged(this, "progressTintColor")
            this.progressView.edo_backgroundColor = value
        }

    var trackTintColor: UIColor? = null
        set(value) {
            field = value
            EDOJavaHelper.valueChanged(this, "trackTintColor")
            this.trackView.edo_backgroundColor = value
        }

    // Implementation

    var trackView = UIView()
    var progressView = UIView()

    init {
        this.progressTintColor = this.tintColor
        this.trackTintColor = this.tintColor?.colorWithAlphaComponent(0.35)
        this.addSubview(this.trackView)
        this.addSubview(this.progressView)
    }

    override fun layoutSubviews() {
        super.layoutSubviews()
        this.trackView.frame = this.bounds
        this.progressView.frame = CGRect(0.0, 0.0, this.bounds.width * this.progress, this.bounds.height)
    }

}

fun KIMIPackage.installUIProgressView() {
    exporter.exportClass(UIProgressView::class.java, "UIProgressView", "UIView")
    exporter.exportProperty(UIProgressView::class.java, "progress", false, true, true)
    exporter.exportProperty(UIProgressView::class.java, "progressTintColor", false, true, true)
    exporter.exportProperty(UIProgressView::class.java, "trackTintColor", false, true, true)
    exporter.exportMethodToJavaScript(UIProgressView::class.java, "setProgress")
}