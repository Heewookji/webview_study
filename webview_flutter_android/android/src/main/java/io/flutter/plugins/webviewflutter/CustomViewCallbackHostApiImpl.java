// Copyright 2013 The Flutter Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package io.flutter.plugins.webviewflutter;

import android.webkit.WebChromeClient.CustomViewCallback;

import androidx.annotation.NonNull;

import java.util.Objects;

import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView.CustomViewCallbackHostApi;

public class CustomViewCallbackHostApiImpl implements CustomViewCallbackHostApi {
  private final BinaryMessenger binaryMessenger;

  private final InstanceManager instanceManager;

  public CustomViewCallbackHostApiImpl(
      @NonNull BinaryMessenger binaryMessenger, @NonNull InstanceManager instanceManager) {
    this.binaryMessenger = binaryMessenger;
    this.instanceManager = instanceManager;
  }

  @Override
  public void onCustomViewHidden(@NonNull Long identifier) {
    onCustomViewHiddenInstance(identifier).onCustomViewHidden();
  }

  private CustomViewCallback onCustomViewHiddenInstance(@NonNull Long identifier) {
    return Objects.requireNonNull(instanceManager.getInstance(identifier));
  }
}
