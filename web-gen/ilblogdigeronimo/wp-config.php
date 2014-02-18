<?php
/**
 * The base configurations of the WordPress.
 *
 * This file has the following configurations: MySQL settings, Table Prefix,
 * Secret Keys, WordPress Language, and ABSPATH. You can find more information
 * by visiting {@link http://codex.wordpress.org/Editing_wp-config.php Editing
 * wp-config.php} Codex page. You can get the MySQL settings from your web host.
 *
 * This file is used by the wp-config.php creation script during the
 * installation. You don't have to use the web site, you can just copy this file
 * to "wp-config.php" and fill in the values.
 *
 * @package WordPress
 */

// ** MySQL settings - You can get this info from your web host ** //
/** The name of the database for WordPress */
define('DB_NAME', 'marninze_gero');

/** MySQL database username */
define('DB_USER', 'marninze_gero');

/** MySQL database password */
define('DB_PASSWORD', 'er5//,ko1');

/** MySQL hostname */
define('DB_HOST', 'localhost');

/** Database Charset to use in creating database tables. */
define('DB_CHARSET', 'utf8');

/** The Database Collate type. Don't change this if in doubt. */
define('DB_COLLATE', '');

/**#@+
 * Authentication Unique Keys and Salts.
 *
 * Change these to different unique phrases!
 * You can generate these using the {@link https://api.wordpress.org/secret-key/1.1/salt/ WordPress.org secret-key service}
 * You can change these at any point in time to invalidate all existing cookies. This will force all users to have to log in again.
 *
 * @since 2.6.0
 */
define('AUTH_KEY',         '}aCM`HNpZnL]a]N7NXfA,L-_-eFGJK!pGc1[c{Y0g&XYW{h53#1981}|)H+gWE()');
define('SECURE_AUTH_KEY',  'Ds@N5-jzAST,cU6jh%^$YXXI|$Y}5|(o%}|As]|(A`O(x^D}SqWD>OfT~AsiD2{V');
define('LOGGED_IN_KEY',    '<rm..dp(blaj,*)$Uvc1#Y>=AERbUr1=d^&H$k8_0g/[+wD8FCwxQ@E$QeU%mC#D');
define('NONCE_KEY',        'Ath:(|[c^?#hE>1!77TM)]>3Q<M,Xhw3oaaiqI, ?p6_JdSym=Q6LhQsbN=ox`);');
define('AUTH_SALT',        ' y_5N??`txQ]01_sl=|+X^b<Jk|,AY3(7ofS;&(}1g!XP7@Da1<|O`u@[0]KDm>T');
define('SECURE_AUTH_SALT', '+H0NlzV#kj)1}yQ|GsXxa;}0Bw(bz|]#F/+o]Um;zD~<62`H~$Dzz%m(YCp_towu');
define('LOGGED_IN_SALT',   'n7LtI=g3i`0)h;(_U)7Ku6y3MW:jz-4br+< ?xF0PwlEGynw&t}!2,.yyWD7wgHG');
define('NONCE_SALT',       'PXX0oa)vNF$B6=u>+5juR:<}OW?X@>/Whyga,g_kRUTC4]Msxw-$D!D|1zf_*O4H');
/**#@-*/

/**
 * WordPress Database Table prefix.
 *
 * You can have multiple installations in one database if you give each a unique
 * prefix. Only numbers, letters, and underscores please!
 */
$table_prefix  = 'wp_';

/**
 * WordPress Localized Language, defaults to English.
 *
 * Change this to localize WordPress. A corresponding MO file for the chosen
 * language must be installed to wp-content/languages. For example, install
 * de_DE.mo to wp-content/languages and set WPLANG to 'de_DE' to enable German
 * language support.
 */
define('WPLANG', '');

/**
 * For developers: WordPress debugging mode.
 *
 * Change this to true to enable the display of notices during development.
 * It is strongly recommended that plugin and theme developers use WP_DEBUG
 * in their development environments.
 */
define('WP_DEBUG', false);

/* That's all, stop editing! Happy blogging. */

/** Absolute path to the WordPress directory. */
if ( !defined('ABSPATH') )
	define('ABSPATH', dirname(__FILE__) . '/');

/** Sets up WordPress vars and included files. */
require_once(ABSPATH . 'wp-settings.php');
