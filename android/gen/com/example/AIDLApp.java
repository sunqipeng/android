/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: /Users/sunqipeng/Documents/ideaProject/android/src/com/example/AIDLApp.aidl
 */
package com.example;
/**
 * Created by IntelliJ IDEA.
 * User: sunqipeng
 * Date: 11-8-12
 * Time: 上午12:49
 * To change this template use File | Settings | File Templates.
 */
public interface AIDLApp extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.example.AIDLApp
{
private static final java.lang.String DESCRIPTOR = "com.example.AIDLApp";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.example.AIDLApp interface,
 * generating a proxy if needed.
 */
public static com.example.AIDLApp asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.example.AIDLApp))) {
return ((com.example.AIDLApp)iin);
}
return new com.example.AIDLApp.Stub.Proxy(obj);
}
public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_printMessage:
{
data.enforceInterface(DESCRIPTOR);
this.printMessage();
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.example.AIDLApp
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
public android.os.IBinder asBinder()
{
return mRemote;
}
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
public void printMessage() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_printMessage, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
static final int TRANSACTION_printMessage = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
}
public void printMessage() throws android.os.RemoteException;
}
