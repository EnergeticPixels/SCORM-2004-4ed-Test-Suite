## Phase 0 Quality, Accessibility, and Security Guardrails (v1)

Status: Adopted baseline
Version: 1.0
Last Updated: 2026-08-26
Source backlog: [phase0_sprint-planning_backlog.md](phase0_sprint-planning_backlog.md)
Source closure checklist: [phase0_closure_checklist.md](phase0_closure_checklist.md)

### Purpose
Define mandatory engineering guardrails for modernization work so changes remain testable, accessible, secure, and auditable.

### Scope
1. Applies to all Phase 1 and later modernization tasks.
1. Applies to code, build changes, browser-side changes, and evidence artifacts.
1. Legacy baseline capture work in Phase 1 must follow evidence and change-control portions of these guardrails.

### Quality Guardrails
1. No change is complete without explicit acceptance criteria.
1. No change is marked Done without evidence links.
1. Any behavior-affecting change must include regression evidence against baseline expectations.
1. Unit tests are required for deterministic logic changes where practical.
1. Functional verification is required for workflow-affecting changes.
1. Estimate changes above 30% require note in risk register.
1. Keep pull requests/issues small enough for one focused review pass.

### Accessibility Guardrails (WCAG 2.2 AA Target)
1. New or modified UI must preserve keyboard-only operability.
1. Visible focus states are required for interactive controls.
1. Form controls require labels and clear error messaging.
1. Color contrast must meet WCAG 2.2 AA thresholds where text or controls are changed.
1. Semantic structure and landmarks are required when replacing legacy frameset-style layouts.
1. Accessibility verification evidence must include both automated checks and manual checks.

### Security Guardrails
1. OpenJDK distribution and version must be explicitly documented before build/runtime use.
1. Third-party dependencies require source/provenance tracking and vulnerability review.
1. Do not introduce network dependency in client-only phase unless explicitly approved.
1. Local file operations must be explicit, minimal, and auditable.
1. No secrets or credentials are stored in repository files.
1. Any discovered security-impacting behavior is logged as a risk register entry.

### Evidence Requirements (Audit-Ready)
For each completed item, provide links to:
1. Acceptance criteria used.
1. Test or verification output.
1. Regression comparison notes if behavior changed.
1. Accessibility checks (if UI affected).
1. Security review notes (if dependencies/runtime changed).

### Definition of Done Addendum
A backlog item can be moved to Done only if:
1. Acceptance criteria are met.
1. Required evidence links are present.
1. Any risk/estimate changes are documented.
1. Accessibility and security checks are completed where applicable.

### Adoption Record
- QA (James Holden): Adopted, 2026-08-26
- A11Y (Camina Drummer): Adopted, 2026-08-26
- SEC (Bobbie Draper): Adopted, 2026-08-26
- TL (Josephus Miller): Adopted, 2026-08-26

### Version History
- v1.0 (2026-08-26): Initial guardrails baseline for quality, accessibility, and security.
