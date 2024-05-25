package app.katyaos.apps.core;

// Hidden but useful constants from android.content.pm.PackageManager
public class PackageManagerConstants {
    /**
     * Installation return code: this is passed in the {PackageInstaller#EXTRA_LEGACY_STATUS}
     * if the package is already installed.
     */
    public static final int INSTALL_FAILED_ALREADY_EXISTS = -1;

    /**
     * Installation return code: this is passed in the {PackageInstaller#EXTRA_LEGACY_STATUS}
     * if the package archive file is invalid.
     */
    public static final int INSTALL_FAILED_INVALID_APK = -2;

    /**
     * Installation return code: this is passed in the {PackageInstaller#EXTRA_LEGACY_STATUS}
     * if the URI passed in is invalid.
     */
    public static final int INSTALL_FAILED_INVALID_URI = -3;

    /**
     * Installation return code: this is passed in the {PackageInstaller#EXTRA_LEGACY_STATUS}
     * if the package manager service found that the device didn't have enough storage space to
     * install the app.
     */
    public static final int INSTALL_FAILED_INSUFFICIENT_STORAGE = -4;

    /**
     * Installation return code: this is passed in the {PackageInstaller#EXTRA_LEGACY_STATUS}
     * if a package is already installed with the same name.
     */
    public static final int INSTALL_FAILED_DUPLICATE_PACKAGE = -5;

    /**
     * Installation return code: this is passed in the {PackageInstaller#EXTRA_LEGACY_STATUS}
     * if the requested shared user does not exist.
     */
    public static final int INSTALL_FAILED_NO_SHARED_USER = -6;

    /**
     * Installation return code: this is passed in the {PackageInstaller#EXTRA_LEGACY_STATUS}
     * if a previously installed package of the same name has a different signature than the new
     * package (and the old package's data was not removed).
     */
    public static final int INSTALL_FAILED_UPDATE_INCOMPATIBLE = -7;

    /**
     * Installation return code: this is passed in the {PackageInstaller#EXTRA_LEGACY_STATUS}
     * if the new package is requested a shared user which is already installed on the device and
     * does not have matching signature.
     */
    public static final int INSTALL_FAILED_SHARED_USER_INCOMPATIBLE = -8;

    /**
     * Installation return code: this is passed in the {PackageInstaller#EXTRA_LEGACY_STATUS}
     * if the new package uses a shared library that is not available.
     */
    public static final int INSTALL_FAILED_MISSING_SHARED_LIBRARY = -9;

    /**
     * Installation return code: this is passed in the {PackageInstaller#EXTRA_LEGACY_STATUS}
     * when the package being replaced is a system app and the caller didn't provide the
     * {#DELETE_SYSTEM_APP} flag.
     */
    public static final int INSTALL_FAILED_REPLACE_COULDNT_DELETE = -10;

    /**
     * Installation return code: this is passed in the {PackageInstaller#EXTRA_LEGACY_STATUS}
     * if the new package failed while optimizing and validating its dex files, either because there
     * was not enough storage or the validation failed.
     */
    public static final int INSTALL_FAILED_DEXOPT = -11;

    /**
     * Installation return code: this is passed in the {PackageInstaller#EXTRA_LEGACY_STATUS}
     * if the new package failed because the current SDK version is older than that required by the
     * package.
     */
    public static final int INSTALL_FAILED_OLDER_SDK = -12;

    /**
     * Installation return code: this is passed in the {PackageInstaller#EXTRA_LEGACY_STATUS}
     * if the new package failed because it contains a content provider with the same authority as a
     * provider already installed in the system.
     */
    public static final int INSTALL_FAILED_CONFLICTING_PROVIDER = -13;

    /**
     * Installation return code: this is passed in the {PackageInstaller#EXTRA_LEGACY_STATUS}
     * if the new package failed because the current SDK version is newer than that required by the
     * package.
     */
    public static final int INSTALL_FAILED_NEWER_SDK = -14;

    /**
     * Installation return code: this is passed in the {PackageInstaller#EXTRA_LEGACY_STATUS}
     * if the new package failed because it has specified that it is a test-only package and the
     * caller has not supplied the {#INSTALL_ALLOW_TEST} flag.
     */
    public static final int INSTALL_FAILED_TEST_ONLY = -15;

    /**
     * Installation return code: this is passed in the {PackageInstaller#EXTRA_LEGACY_STATUS}
     * if the package being installed contains native code, but none that is compatible with the
     * device's CPU_ABI.
     */
    public static final int INSTALL_FAILED_CPU_ABI_INCOMPATIBLE = -16;

    /**
     * Installation return code: this is passed in the {PackageInstaller#EXTRA_LEGACY_STATUS}
     * if the new package uses a feature that is not available.
     */
    public static final int INSTALL_FAILED_MISSING_FEATURE = -17;

    // ------ Errors related to sdcard
    /**
     * Installation return code: this is passed in the
     * {PackageInstaller#EXTRA_LEGACY_STATUS} if a secure container mount point couldn't be
     * accessed on external media.
     */
    public static final int INSTALL_FAILED_CONTAINER_ERROR = -18;

    /**
     * Installation return code: this is passed in the {PackageInstaller#EXTRA_LEGACY_STATUS}
     * if the new package couldn't be installed in the specified install location.
     */
    public static final int INSTALL_FAILED_INVALID_INSTALL_LOCATION = -19;

    /**
     * Installation return code: this is passed in the {PackageInstaller#EXTRA_LEGACY_STATUS}
     * if the new package couldn't be installed in the specified install location because the media
     * is not available.
     */
    public static final int INSTALL_FAILED_MEDIA_UNAVAILABLE = -20;

    /**
     * Installation return code: this is passed in the {PackageInstaller#EXTRA_LEGACY_STATUS}
     * if the new package couldn't be installed because the verification timed out.
     */
    public static final int INSTALL_FAILED_VERIFICATION_TIMEOUT = -21;

    /**
     * Installation return code: this is passed in the {PackageInstaller#EXTRA_LEGACY_STATUS}
     * if the new package couldn't be installed because the verification did not succeed.
     */
    public static final int INSTALL_FAILED_VERIFICATION_FAILURE = -22;

    /**
     * Installation return code: this is passed in the {PackageInstaller#EXTRA_LEGACY_STATUS}
     * if the package changed from what the calling program expected.
     */
    public static final int INSTALL_FAILED_PACKAGE_CHANGED = -23;

    /**
     * Installation return code: this is passed in the {PackageInstaller#EXTRA_LEGACY_STATUS}
     * if the new package is assigned a different UID than it previously held.
     */
    public static final int INSTALL_FAILED_UID_CHANGED = -24;

    /**
     * Installation return code: this is passed in the {PackageInstaller#EXTRA_LEGACY_STATUS}
     * if the new package has an older version code than the currently installed package.
     */
    public static final int INSTALL_FAILED_VERSION_DOWNGRADE = -25;

    /**
     * Installation return code: this is passed in the {PackageInstaller#EXTRA_LEGACY_STATUS}
     * if the old package has target SDK high enough to support runtime permission and the new
     * package has target SDK low enough to not support runtime permissions.
     */
    public static final int INSTALL_FAILED_PERMISSION_MODEL_DOWNGRADE = -26;

    /**
     * Installation return code: this is passed in the {PackageInstaller#EXTRA_LEGACY_STATUS}
     * if the new package attempts to downgrade the target sandbox version of the app.
     */
    public static final int INSTALL_FAILED_SANDBOX_VERSION_DOWNGRADE = -27;

    /**
     * Installation return code: this is passed in the {PackageInstaller#EXTRA_LEGACY_STATUS}
     * if the new package requires at least one split and it was not provided.
     */
    public static final int INSTALL_FAILED_MISSING_SPLIT = -28;

    /**
     * Installation parse return code: this is passed in the
     * {PackageInstaller#EXTRA_LEGACY_STATUS} if the parser was given a path that is not a
     * file, or does not end with the expected '.apk' extension.
     */
    public static final int INSTALL_PARSE_FAILED_NOT_APK = -100;

    /**
     * Installation parse return code: this is passed in the
     * {PackageInstaller#EXTRA_LEGACY_STATUS} if the parser was unable to retrieve the
     * AndroidManifest.xml file.
     */
    public static final int INSTALL_PARSE_FAILED_BAD_MANIFEST = -101;

    /**
     * Installation parse return code: this is passed in the
     * {PackageInstaller#EXTRA_LEGACY_STATUS} if the parser encountered an unexpected
     * exception.
     */
    public static final int INSTALL_PARSE_FAILED_UNEXPECTED_EXCEPTION = -102;

    /**
     * Installation parse return code: this is passed in the
     * {PackageInstaller#EXTRA_LEGACY_STATUS} if the parser did not find any certificates in
     * the .apk.
     */
    public static final int INSTALL_PARSE_FAILED_NO_CERTIFICATES = -103;

    /**
     * Installation parse return code: this is passed in the
     * {PackageInstaller#EXTRA_LEGACY_STATUS} if the parser found inconsistent certificates on
     * the files in the .apk.
     */
    public static final int INSTALL_PARSE_FAILED_INCONSISTENT_CERTIFICATES = -104;

    /**
     * Installation parse return code: this is passed in the
     * {PackageInstaller#EXTRA_LEGACY_STATUS} if the parser encountered a
     * CertificateEncodingException in one of the files in the .apk.
     */
    public static final int INSTALL_PARSE_FAILED_CERTIFICATE_ENCODING = -105;

    /**
     * Installation parse return code: this is passed in the
     * {PackageInstaller#EXTRA_LEGACY_STATUS} if the parser encountered a bad or missing
     * package name in the manifest.
     */
    public static final int INSTALL_PARSE_FAILED_BAD_PACKAGE_NAME = -106;

    /**
     * Installation parse return code: tthis is passed in the
     * {PackageInstaller#EXTRA_LEGACY_STATUS} if the parser encountered a bad shared user id
     * name in the manifest.
     */
    public static final int INSTALL_PARSE_FAILED_BAD_SHARED_USER_ID = -107;

    /**
     * Installation parse return code: this is passed in the
     * {PackageInstaller#EXTRA_LEGACY_STATUS} if the parser encountered some structural
     * problem in the manifest.
     */
    public static final int INSTALL_PARSE_FAILED_MANIFEST_MALFORMED = -108;

    /**
     * Installation parse return code: this is passed in the
     * {PackageInstaller#EXTRA_LEGACY_STATUS} if the parser did not find any actionable tags
     * (instrumentation or application) in the manifest.
     */
    public static final int INSTALL_PARSE_FAILED_MANIFEST_EMPTY = -109;

    /**
     * Installation failed return code: this is passed in the
     * {PackageInstaller#EXTRA_LEGACY_STATUS} if the system failed to install the package
     * because of system issues.
     */
    public static final int INSTALL_FAILED_INTERNAL_ERROR = -110;

    /**
     * Installation failed return code: this is passed in the
     * {PackageInstaller#EXTRA_LEGACY_STATUS} if the system failed to install the package
     * because the user is restricted from installing apps.
     */
    public static final int INSTALL_FAILED_USER_RESTRICTED = -111;

    /**
     * Installation failed return code: this is passed in the
     * {PackageInstaller#EXTRA_LEGACY_STATUS} if the system failed to install the package
     * because it is attempting to define a permission that is already defined by some existing
     * package.
     * <p>
     * The package name of the app which has already defined the permission is passed to a
     * {PackageInstallObserver}, if any, as the {#EXTRA_FAILURE_EXISTING_PACKAGE} string
     * extra; and the name of the permission being redefined is passed in the
     * {#EXTRA_FAILURE_EXISTING_PERMISSION} string extra.
     */
    public static final int INSTALL_FAILED_DUPLICATE_PERMISSION = -112;

    /**
     * Installation failed return code: this is passed in the
     * {PackageInstaller#EXTRA_LEGACY_STATUS} if the system failed to install the package
     * because its packaged native code did not match any of the ABIs supported by the system.
     */
    public static final int INSTALL_FAILED_NO_MATCHING_ABIS = -113;

    public static final int INSTALL_FAILED_ABORTED = -115;

    /**
     * Installation failed return code: install type is incompatible with some other
     * installation flags supplied for the operation; or other circumstances such as trying
     * to upgrade a system app via an Incremental or instant app install.
     */
    public static final int INSTALL_FAILED_SESSION_INVALID = -116;

    /**
     * Installation parse return code: this is passed in the
     * {PackageInstaller#EXTRA_LEGACY_STATUS} if the dex metadata file is invalid or
     * if there was no matching apk file for a dex metadata file.
     */
    public static final int INSTALL_FAILED_BAD_DEX_METADATA = -117;

    /**
     * Installation parse return code: this is passed in the
     * {PackageInstaller#EXTRA_LEGACY_STATUS} if there is any signature problem.
     */
    public static final int INSTALL_FAILED_BAD_SIGNATURE = -118;

    /**
     * Installation failed return code: a new staged session was attempted to be committed while
     * there is already one in-progress or new session has package that is already staged.
     */
    public static final int INSTALL_FAILED_OTHER_STAGED_SESSION_IN_PROGRESS = -119;

    /**
     * Installation failed return code: one of the child sessions does not match the parent session
     * in respect to staged or rollback enabled parameters.
     */
    public static final int INSTALL_FAILED_MULTIPACKAGE_INCONSISTENCY = -120;

    /**
     * Installation failed return code: the required installed version code
     * does not match the currently installed package version code.
     */
    public static final int INSTALL_FAILED_WRONG_INSTALLED_VERSION = -121;

    /**
     * Installation return code: this is passed in the {PackageInstaller#EXTRA_LEGACY_STATUS}
     * if the new package failed because it contains a request to use a process that was not
     * explicitly defined as part of its &lt;processes&gt; tag.
     */
    public static final int INSTALL_FAILED_PROCESS_NOT_DEFINED = -122;

    /**
     * Installation parse return code: system is in a minimal boot state, and the parser only
     * allows the package with {@code coreApp} manifest attribute to be a valid application.
     */
    public static final int INSTALL_PARSE_FAILED_ONLY_COREAPP_ALLOWED = -123;

    /**
     * Installation failed return code: the {@code resources.arsc} of one of the APKs being
     * installed is compressed or not aligned on a 4-byte boundary. Resource tables that cannot be
     * memory mapped exert excess memory pressure on the system and drastically slow down
     * construction of {Resources} objects.
     */
    public static final int INSTALL_PARSE_FAILED_RESOURCES_ARSC_COMPRESSED = -124;

    /**
     * Installation failed return code: the package was skipped and should be ignored.
     * The reason for the skip is undefined.
     */
    public static final int INSTALL_PARSE_FAILED_SKIPPED = -125;

    /**
     * Installation failed return code: this is passed in the
     * {PackageInstaller#EXTRA_LEGACY_STATUS} if the system failed to install the package
     * because it is attempting to define a permission group that is already defined by some
     * existing package.
     */
    public static final int INSTALL_FAILED_DUPLICATE_PERMISSION_GROUP = -126;

    /**
     * Installation failed return code: this is passed in the
     * {PackageInstaller#EXTRA_LEGACY_STATUS} if the system failed to install the package
     * because it is attempting to define a permission in a group that does not exists or that is
     * defined by an packages with an incompatible certificate.
     */
    public static final int INSTALL_FAILED_BAD_PERMISSION_GROUP = -127;

    /**
     * Installation failed return code: an error occurred during the activation phase of this
     * session.
     */
    public static final int INSTALL_ACTIVATION_FAILED = -128;

    /**
     * Return code for when package deletion succeeds. This is passed to the
     * {IPackageDeleteObserver} if the system succeeded in deleting the
     * package.
     */
    public static final int DELETE_SUCCEEDED = 1;

    /**
     * Deletion failed return code: this is passed to the
     * {IPackageDeleteObserver} if the system failed to delete the package
     * for an unspecified reason.
     */
    public static final int DELETE_FAILED_INTERNAL_ERROR = -1;

    /**
     * Deletion failed return code: this is passed to the
     * {IPackageDeleteObserver} if the system failed to delete the package
     * because it is the active DevicePolicy manager.
     */
    public static final int DELETE_FAILED_DEVICE_POLICY_MANAGER = -2;

    /**
     * Deletion failed return code: this is passed to the
     * {IPackageDeleteObserver} if the system failed to delete the package
     * since the user is restricted.
     */
    public static final int DELETE_FAILED_USER_RESTRICTED = -3;

    /**
     * Deletion failed return code: this is passed to the
     * {IPackageDeleteObserver} if the system failed to delete the package
     * because a profile or device owner has marked the package as
     * uninstallable.
     */
    public static final int DELETE_FAILED_OWNER_BLOCKED = -4;

    public static final int DELETE_FAILED_ABORTED = -5;

    /**
     * Deletion failed return code: this is passed to the
     * {IPackageDeleteObserver} if the system failed to delete the package
     * because the packge is a shared library used by other installed packages.
     *
     * */
    public static final int DELETE_FAILED_USED_SHARED_LIBRARY = -6;

    /**
     * Deletion failed return code: this is passed to the
     * {IPackageDeleteObserver} if the system failed to delete the package
     * because there is an app pinned.
     */
    public static final int DELETE_FAILED_APP_PINNED = -7;
}
