#pragma once

#include <QDebug>
#include <QLoggingCategory>

Q_DECLARE_LOGGING_CATEGORY(auris)

#define LOG_INFO(msg) qCInfo(auris) << "\033[32m" << msg << "\033[0m"
#define LOG_WARN(msg) qCWarning(auris) << "\033[33m" << msg << "\033[0m"
#define LOG_ERROR(msg) qCCritical(auris) << "\033[31m" << msg << "\033[0m"
#define LOG_DEBUG(msg) qCDebug(auris) << "\033[34m" << msg << "\033[0m"
